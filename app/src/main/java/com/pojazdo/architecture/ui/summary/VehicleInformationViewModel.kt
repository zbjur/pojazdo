package com.pojazdo.architecture.ui.summary

import com.mobile.base.ApplicationScheduler
import com.pojazdo.architecture.ui.Event
import com.pojazdo.architecture.ui.base.Command
import com.pojazdo.architecture.ui.base.ViewModelBase
import com.pojazdo.architecture.ui.summary.converter.VehicleInformationConverter
import com.pojazdo.architecture.ui.summary.model.modelsection.VehicleSections
import com.pojazdo.usecases.vehicleInformation.VehicleInformationApi
import io.reactivex.functions.Consumer
import javax.inject.Inject

class VehicleInformationViewModel @Inject constructor(private val scheduler: ApplicationScheduler,
                                                      private val vehicleInformationApi: VehicleInformationApi,
                                                      private val vehicleInformationConverter: VehicleInformationConverter) : ViewModelBase() {


    fun checkVehicleInformation(vin: String, registerNumber: String, registrationDate: String) {
        showProgress()
        scheduler.schedule(vehicleInformationApi.checkVehicleInformation(vin, registerNumber, registrationDate),
                Consumer {
                    hideProgress()
                    vehicleInformationConverter.convertToVehicleSectionList(it).let { vehicleInformationList ->
                        showVehicleInfo(vehicleInformationList)
                    }
                }, Consumer {
            handleErrorResponse(it)
        })
    }

    private fun showVehicleInfo(it: MutableList<VehicleSections>?) {
        viewState.postValue(Event(Command.ShowVehicleInfo(it)))
    }

    private fun handleErrorResponse(it: Throwable) {
        viewState.postValue(Event(Command.Error(it.message)))
    }
}