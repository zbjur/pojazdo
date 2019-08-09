package com.pojazdo.api.network.vehiclehtmlparser

import com.google.common.base.Charsets
import com.google.common.io.Resources
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test


class VehicleHtmlParserServiceFeedTest {

    val server = MockWebServer()

    val htmlVehicleHistoryResponse = ""
    val htmlVehicleRatingSummaryResponse = ""
    lateinit var serverUrl: String
    val systemUnderTest = VehicleHtmlParserServiceFeed(OkHttpClient())

    @Before
    fun setUp() {
        server.start()
        serverUrl = server.url("/").toString()
    }

    @Test
    fun parseVehicleHistoryHtmlResponse() {
        enqueueResponse("json/vehicle_history.json")

        val response = systemUnderTest.parseVehicleHistoryHtmlResponse(serverUrl, htmlVehicleHistoryResponse).test()
        val actualValue = response.values()[0]

        response.assertNoErrors()
        response.assertComplete()

        Assertions.assertThat(actualValue.brand).isEqualTo("Skoda")
        Assertions.assertThat(actualValue.model).isEqualTo("Roomster")
    }

    @Test
    fun `not complete when parsing history html response error`() {
        server.enqueue(MockResponse().setBody("").setResponseCode(500))
        val response = systemUnderTest.parseVehicleHistoryHtmlResponse(serverUrl, htmlVehicleHistoryResponse).test()

        response.assertNotComplete()
    }

    @Test
    fun parseVehicleRatingHtmlResponse() {

        enqueueResponse("json/vehicle_rating_summary.json")
        val response = systemUnderTest.parseVehicleRatingHtmlResponse(serverUrl, htmlVehicleRatingSummaryResponse).test()

        val actualValue = response.values()[0]

        response.assertNoErrors()
        response.assertComplete()
        Assertions.assertThat(actualValue.buyAgainPercentage).isEqualTo("69%")
    }

    @Test
    fun `not complete when parsing rating html response error`() {
        server.enqueue(MockResponse().setBody("").setResponseCode(500))

        val response = systemUnderTest.parseVehicleRatingHtmlResponse(serverUrl, htmlVehicleRatingSummaryResponse).test()

        response.assertNotComplete()
    }

    private fun enqueueResponse(fileName: String) {
        val response = Resources.toString(Resources.getResource(fileName), Charsets.UTF_8)
        val mockResponse = MockResponse()
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .addHeader("Cache-Control", "no-cache")
                .setBody(response)
                .setResponseCode(200)
        server.enqueue(mockResponse)
    }


}