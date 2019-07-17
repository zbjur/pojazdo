package com.pojazdo.architecture.ui.aztecscanner

import com.pojazdo.architecture.AndroidTestScheduler
import com.pojazdo.architecture.ui.Event
import com.pojazdo.architecture.ui.base.Command
import com.pojazdo.data.network.vehicledecoder.model.VehicleDecodedInfo
import com.pojazdo.usecases.vehicleaztecdecoder.VehicleDecoderApi
import com.mobile.base.ApplicationScheduler
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.Single
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString


class VehicleScannerViewModelTest {
    val mockScheduler: ApplicationScheduler = AndroidTestScheduler()
    val mockvehicleDecoderApi: VehicleDecoderApi = mock { on { decodeAztecCode(anyString(), anyString(), anyString()) } doReturn Single.just(VehicleDecodedInfo("", "", "")) }
    val systemUnderTest: VehicleScannerViewModel = VehicleScannerViewModel(mockScheduler, mockvehicleDecoderApi)


/*    @Test
    fun `check vehicle`() {
        val viewState = MutableLiveData<Event<Command>>()
        systemUnderTest.checkVehicleRating(anyString(), anyString(), anyString())
        //  verify(showVehicleResult, times(1)).postValue(Event())
    }*/

    @Test
    fun `decode aztec code and show on the screen`() {
        val expectedResult = Event(Command.NavigateToScannerView())

        systemUnderTest.onScanButtonClick()

        systemUnderTest.viewState

        //  Assert.assertThat(expectedResult, systemUnderTest.viewState.javaClas)

    }

    @Test
    fun `decode aztec code error`() {

        val myFun = { x: Int, y: Int -> x + y }
        val myFun2: (Int, Int) -> Int = { x, y -> x + y }

        val fa = 1..4
       fa.filter { it.equals(2) }

    }

    fun test(com: (Int, Int) -> Int) {
        val s: Int = com(2, 3)
    }

}