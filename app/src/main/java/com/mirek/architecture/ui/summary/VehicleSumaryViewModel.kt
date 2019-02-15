package com.mirek.architecture.ui.summary

import com.mirek.architecture.ui.Event
import com.mirek.architecture.ui.base.Command
import com.mirek.architecture.ui.base.ViewModelBase
import com.mirek.usecases.vehicleinfo.VehicleInfoApi
import com.mobile.base.ApplicationScheduler
import io.reactivex.functions.Consumer
import javax.inject.Inject

class VehicleSumaryViewModel : ViewModelBase {
    private val scheduler: ApplicationScheduler
    private val vehicleInfoApi: VehicleInfoApi

    @Inject constructor(scheduler: ApplicationScheduler, vehicleInfoApi: VehicleInfoApi) : super() {
        this.scheduler = scheduler

        this.vehicleInfoApi = vehicleInfoApi
    }

    fun checkVehicle(registerNumber: String, vin: String, registrationDate: String) {
        showProgress()
        scheduler.schedule(vehicleInfoApi.checkVehicle(registerNumber, registrationDate, vin),
                Consumer {
                    hideProgress()
                    //showVehicleResult
                }, Consumer {
            handleErrorResponse(it)
        })
    }

    private fun handleErrorResponse(it: Throwable) {
        viewState.postValue(Event(Command.Error(it.message)))
    }

}