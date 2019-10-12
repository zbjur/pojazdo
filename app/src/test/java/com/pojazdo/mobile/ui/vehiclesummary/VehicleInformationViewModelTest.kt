package com.pojazdo.mobile.ui.vehiclesummary

import io.reactivex.Observable
import io.reactivex.functions.Consumer
import io.reactivex.rxkotlin.toObservable
import org.junit.Test

class VehicleInformationViewModelTest {

    @Test
    fun checkVehicleInformation() {
    }


    @Test
    fun observable() {


        val observable = listOf(1, 2, 3).toObservable()
         observable.flatMap { Observable.just(it).map {

         } }

        observable.subscribe(
                Consumer {
                    print("print ${it} ")
                },
                Consumer { it })


    }
}