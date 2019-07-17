package com.pojazdo.usecases.vehiclehtmlparser

import com.pojazdo.api.network.vehiclehtmlparser.VehicleHtmlParserBackendApi
import com.pojazdo.api.network.vehicleinfo.model.VehicleHistoryHtmlResponse
import com.nhaarman.mockito_kotlin.mock
import org.junit.Test

class VehicleHtmlParserServiceTest {

    val mockVehicleHtmlParserBackendApi: VehicleHtmlParserBackendApi = mock {
        /*on {  parseVehicleHistoryHtmlResponse(any(),any())}.thenReturn(VehicleHistoryPojo("",""))
        on {  parseVehicleRatingHtmlResponse(any(),any())}.thenReturn(VehicleRatingSummaryPojo())*/
    }

    val systemUnderTest = VehicleHtmlParserService(mockVehicleHtmlParserBackendApi)

    @Test
    fun parseVehicleHistoryHtmlR() {
      //  VehicleDataFactory()
        systemUnderTest.parseVehicleHistoryHtmlResponse(VehicleHistoryHtmlResponse(""))
    }

    @Test
    fun parseVehicleRatingHtmlR() {

    }
}