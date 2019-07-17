package com.pojazdo.usecases.vehicleinfo

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import org.junit.Test

class VehicleInfoServiceTest {

    interface Response

    class CarResponse(val brand: String) : Response

    class RatingRespons(val rating: String) : Response


    private fun getRatingHtml(): Observable<String> {
        return Observable.just("4")
    }

    private fun getCarHtml(): Observable<String> {
        return Observable.just("Skoda")
    }

    private fun getRatingResponse(): Observable<Response> {
        return getCarHtml()
                .flatMap { t -> Observable.just(CarResponse(t))}
    }

    private fun getCarResponse(): Observable<Response> {
        return getCarHtml()
                .flatMap { t -> Observable.just(CarResponse(t))}
    }


    @Test
    fun `login user`() {
        getCarResponse()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                })
    }
}