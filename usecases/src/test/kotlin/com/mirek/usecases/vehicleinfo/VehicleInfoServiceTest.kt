package com.mirek.usecases.vehicleinfo

import com.mirek.api.network.htmlparser.VehicleHtmlParserBackendApi
import com.mirek.api.network.htmlparser.model.VehicleInfo
import com.mirek.api.network.vehicleinfo.VehicleInfoBackendApi
import com.mirek.api.network.vehicleinfo.model.VehicleInfoResponse
import com.mirek.usecases.errorhandler.ErrorHandlerApi
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.functions.Consumer
import org.junit.Test


class VehicleInfoServiceTest {

    var vin = ""
    var registrationNumber = ""
    var registrationDate = ""

    val vehicleInfoBackendApi: VehicleInfoBackendApi = mock {
        on {
            checkVehicle("", "", "", "")
        }.thenReturn(Single.just(VehicleInfoResponse("")))
    }

    val vehicleHtmlParserBackendApi: VehicleHtmlParserBackendApi = mock {
        on { parseVehicleResponse(VehicleInfoResponse("")) }.thenReturn(Single.just(VehicleInfo("")))
    }

    val errorHandlerApi: ErrorHandlerApi = mock { }

    val systemUnderTest: VehicleInfoService = VehicleInfoService(vehicleInfoBackendApi, vehicleHtmlParserBackendApi, errorHandlerApi)

    @Test
    fun `load vehicle info`() {
        systemUnderTest.checkVehicle(registrationNumber, registrationDate, vin)
                .test()
                .assertNoErrors()
                .assertValueCount(1)
                .assertComplete()
    }

    @Test
    fun `test`() {

        val observable: Observable<String> = Observable.create<String> {
            //1
            it.onNext("java")
            it.onNext("C++")
            it.onNext("python")
            it.onComplete()
        }

        observable.flatMap { a -> Observable.just(a[10] + " is funny language ") }
                .onErrorReturn { t: Throwable ->
                    when (t) {
                        is Throwable -> ""
                        else -> " "
                    }
                }
                .subscribe(
                        Consumer { t ->
                            System.out.println("jakis atm fe ${t}")
                        },
                        Consumer { System.out.println(" ${it.message}")})

    }

}