package com.pojazdo.api.network.vehiclerating

import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Before

class VehicleRatingPojoServiceFeedTest {

    val server = MockWebServer()
    val brand = "Skoda"
    val model = "Roomster"
    lateinit var serverUrl: String
    val systemUnderTest = VehicleRatingServiceFeed(OkHttpClient())

    @Before
    fun setUp() {
        server.start()
        serverUrl = server.url("/").toString()
    }

 /*   @Test
    fun getVehicleRatingSummary() {
        enqueueResponse("<!DOCTYPE html>\n" + "<html>\n" +
                "<head>\n" +
                "<title>Page Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "</body>\n" +
                "</html>")
        val response = systemUnderTest.checkVehicleRating(serverUrl, brand, model).test()

        response.assertNoErrors()
        response.assertComplete()
    }*/

    private fun enqueueResponse(response: String) {

        val mockResponse = MockResponse()
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .addHeader("Cache-Control", "no-cache")
                .setBody(response)
                .setResponseCode(200)
        server.enqueue(mockResponse)
    }
}