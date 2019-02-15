package com.mirek.architecture.ui.aztecscanner

import com.mirek.architecture.ui.Event
import com.mirek.architecture.ui.base.Command
import com.mirek.architecture.ui.base.ViewModelBase
import com.mirek.api.network.vehicledecoder.model.VehicleDecodedInfo
import com.mirek.usecases.vehicleaztecdecoder.VehicleDecoderApi
import com.mobile.base.ApplicationScheduler
import io.reactivex.functions.Consumer
import javax.inject.Inject

class VehicleScannerViewModel : ViewModelBase {
    private val scheduler: ApplicationScheduler
    private val vehicleDecoderApi: VehicleDecoderApi

    @Inject
    constructor(scheduler: ApplicationScheduler, vehicleDecoderApi: VehicleDecoderApi) : super() {
        this.scheduler = scheduler
        this.vehicleDecoderApi = vehicleDecoderApi

    }

    fun checkVehicle(registerNumber: String, vin: String, registrationDate: String) {
        showVehicleResult(registerNumber, vin, registrationDate)
    }

    fun decodeAztecCode(aztec: String, uniqueKey: String, date: String) {
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
    }

    private fun handleResponseError(it: Throwable) {
        viewState.postValue(Event(Command.Error(it.message)))
    }

    private fun showVehicleDecodedInfo(registerNumber: String, vin: String, registrationDate: String) {
        viewState.postValue(Event(Command.ShowVehicleDecodedInfo(registerNumber, vin, registrationDate)))
    }

    private fun showVehicleResult(registerNumber: String, vin: String, registrationDate: String) {
        viewState.postValue(Event(Command.NavigateToVehicleResultView(registerNumber, vin, registrationDate)))
    }

    fun onScanButtonClick() {
        viewState.postValue(Event(Command.NavigateToScannerView()))
    }

    fun setCarInputDataField() {

    }
}