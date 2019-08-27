package com.pojazdo.architecture.ui.aztecscanner

import com.pojazdo.architecture.ui.Event
import com.pojazdo.architecture.ui.base.Command
import com.pojazdo.architecture.ui.base.ViewModelBase

import com.mobile.base.ApplicationScheduler
import javax.inject.Inject

class VehicleScannerViewModel : ViewModelBase {
    private val scheduler: ApplicationScheduler

    @Inject
    constructor(scheduler: ApplicationScheduler) : super() {
        this.scheduler = scheduler
    }

    fun checkVehicle(registerNumber: String, vin: String, registrationDate: String) {
        showVehicleResult(registerNumber, vin, registrationDate)
    }

/*    fun decodeAztecCode(aztec: String, uniqueKey: String, date: String) {
        showProgress()
        scheduler.schedule(vehicleDecoderApi.decodeAztecCode(aztec, uniqueKey, date),
                Consumer {
                    handleResponse(it)
                }, Consumer {
            handleResponseError(it)
        })
    }

    private fun handleResponse(it: VehicleDecodedInfo) {
        hideProgress()
        showVehicleDecodedInfo(it.registrationNumber, it.vin, it.firstRegistrationDate)
    }*/

    private fun handleResponseError(it: Throwable) {
        viewState.postValue(Event(Command.Error(it.message)))
    }

    private fun showVehicleDecodedInfo(registerNumber: String, vin: String, registrationDate: String) {
        viewState.postValue(Event(Command.NavigateToVehicleDecodedInfo(registerNumber, vin, registrationDate)))
    }

    private fun showVehicleResult(registerNumber: String, vin: String, registrationDate: String) {
        viewState.postValue(Event(Command.NavigateToVehicleResultView(registerNumber, vin, registrationDate)))
    }

    fun onScanButtonClick() {
        viewState.postValue(Event(Command.NavigateToScannerView))
    }

    fun setCarInputDataField() {

    }
}