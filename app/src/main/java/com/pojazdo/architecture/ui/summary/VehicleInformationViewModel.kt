package com.pojazdo.architecture.ui.summary

import androidx.lifecycle.MutableLiveData
import com.mobile.base.ApplicationScheduler
import com.pojazdo.api.database.vehicleadditionalinformation.model.Seller
import com.pojazdo.architecture.ui.Event
import com.pojazdo.architecture.ui.base.Command
import com.pojazdo.architecture.ui.base.ViewModelBase
import com.pojazdo.architecture.ui.summary.converter.VehicleInformationConverter
import com.pojazdo.architecture.ui.summary.model.modelsection.VehicleSections
import com.pojazdo.usecases.editspersoanlellerdata.EditPersonalSellerDataApi
import com.pojazdo.usecases.vehicleInformation.VehicleInformationApi
import io.reactivex.functions.Consumer
import javax.inject.Inject

class VehicleInformationViewModel @Inject constructor(private val scheduler: ApplicationScheduler,
                                                      private val vehicleInformationApi: VehicleInformationApi,
                                                      private val editPersonalSellerDataApi: EditPersonalSellerDataApi,
                                                      private val vehicleInformationConverter: VehicleInformationConverter) : ViewModelBase() {


    var vehicleInformation: MutableLiveData<MutableList<VehicleSections>> = MutableLiveData()

    fun checkVehicleInformation(vin: String, registerNumber: String, registrationDate: String) {
        //showProgress()
        scheduler.schedule(vehicleInformationApi.checkVehicleInformation(vin, registerNumber, registrationDate),
                Consumer { it ->
                    hideProgress()
                    vehicleInformationConverter.convertToVehicleSectionList(it).let {
                        showVehicleInfo(it)
                    }
                }, Consumer {
            handleErrorResponse(it)
        })
    }

    private fun applySellerData(it: Seller) {
        vehicleInformation.value = vehicleInformationConverter.getVehiclePersonalDataSection(vehicleInformation.value, it)
    }

    private fun showVehicleInfo(it: MutableList<VehicleSections>?) {
        //   vehicleInformation?.value = it
        vehicleInformation.postValue(it)
        //  viewState.postValue(Event(Command.PopulateVehicleSummaryViewWithData(it)))
    }

    private fun handleErrorResponse(it: Throwable) {
        // viewState.postValue(Event(Command.Error(it.message)))
    }

    fun showEditPersonalSellerDataView(seller: Seller?) {
        viewState.postValue(Event(Command.NavigateToEditPersonalSellerDataScreenEvent(seller)))
    }

    fun updateSellePersonalData(seller: Seller) {

        scheduler.schedule(editPersonalSellerDataApi.editPersonalSellerData(seller),
                onNextAction = Consumer {
                    applySellerData(it)
                    showVehicleSummaryView(it)
                },
                onErrorAction = Consumer {
                    showError()
                })
        editPersonalSellerDataApi.editPersonalSellerData(seller)
    }

    private fun showVehicleSummaryView(seller: Seller) {
        viewState.postValue(Event(Command.NavigateToVehicleSummaryInfoScreenEvent))
    }

    private fun showError() {
        System.out.println("Error")
    }
}