package com.pojazdo.architecture.ui.summary.editseller

import com.mobile.base.ApplicationScheduler
import com.pojazdo.api.database.vehicleadditionalinformation.model.Seller
import com.pojazdo.architecture.ui.Event
import com.pojazdo.architecture.ui.base.Command
import com.pojazdo.architecture.ui.base.ViewModelBase
import com.pojazdo.usecases.editspersoanlellerdata.EditPersonalSellerDataApi
import io.reactivex.functions.Consumer
import javax.inject.Inject

class EditSellerDataViewModel @Inject constructor(private val scheduler: ApplicationScheduler,
                                                  private val editPersonalSellerDataApi: EditPersonalSellerDataApi) : ViewModelBase() {

    fun updateSellePersonalData(seller: Seller) {

        scheduler.schedule(editPersonalSellerDataApi.editPersonalSellerData(seller),
                onNextAction = Consumer {
                    showVehicleSummaryView(seller)
                },
                onErrorAction = Consumer {
                    showError()
                })
        editPersonalSellerDataApi.editPersonalSellerData(seller)
    }

    private fun showVehicleSummaryView(seller: Seller) {
        viewState.postValue(Event(Command.ShowPersonaSellerData(seller)))
    }

    private fun showError() {
        System.out.println("Error")
    }
}