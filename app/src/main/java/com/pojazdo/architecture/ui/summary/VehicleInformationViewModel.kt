package com.pojazdo.architecture.ui.summary

import com.mobile.base.ApplicationScheduler
import com.pojazdo.api.network.vehicleinformation.model.VehicleInformationPojo
import com.pojazdo.api.network.vehicletrader.model.VehicleOfferedPojo
import com.pojazdo.architecture.ui.Event
import com.pojazdo.architecture.ui.base.Command
import com.pojazdo.architecture.ui.base.ViewModelBase
import com.pojazdo.usecases.vehicleInformation.VehicleInformationApi
import io.reactivex.functions.Consumer
import javax.inject.Inject

class VehicleInformationViewModel : ViewModelBase {
    private val scheduler: ApplicationScheduler
    private val vehicleInformationApi: VehicleInformationApi

    @Inject
    constructor(scheduler: ApplicationScheduler, vehicleInformationApi: VehicleInformationApi) : super() {
        this.scheduler = scheduler
        this.vehicleInformationApi = vehicleInformationApi
    }


    fun checkVehicleHistory(registerNumber: String, vin: String, registrationDate: String) {
        showProgress()
        scheduler.schedule(vehicleInformationApi.checkVehicleInformation(registerNumber, registrationDate, vin)
                ,
                Consumer {
                    hideProgress()
                    showVehicleInfo(it)
                }, Consumer {
            handleErrorResponse(it)
        })
    }


    /*    fun fetchVehicleInformation(registerNumber: String, vin: String, registrationDate: String) {
            showProgress()
            scheduler.schedule(vehicleInformationApi.fetchVehicleInformation(registerNumber, registrationDate, vin)
                    .doAfterSuccess { t: VehicleHistoryPojo? ->
                        checkVehicleRating(t)
                        searchForSimilarVehiclesOffers(t)
                        checkVehiclePrices(t)
                    },
                    Consumer {
                        hideProgress()
                        showVehicleInfo(it)
                    }, Consumer {
                handleErrorResponse(it)
            })
        }*/


    private fun showVehiclePrices(it: String?) {

    }


    private fun showVehicleOffers(it: VehicleOfferedPojo?) {

    }

    private fun showVehicleInfo(it: VehicleInformationPojo?) {
        viewState.postValue(Event(Command.ShowVehicleInfo(it)))
    }

    private fun handleErrorResponse(it: Throwable) {
        viewState.postValue(Event(Command.Error(it.message)))
    }
}