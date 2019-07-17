package com.pojazdo.api.network.vehiclehtmlparser

class VehicleHtmlParserServiceMock() /*: VehicleHtmlParserBackendApi {

    override fun parseVehicleHistoryHtmlResponse(baseUrl: String, vehicleHistoryHtmlString: String): Single<VehicleHistoryPojo> {
        val jsonStringResponse = Resources.toString(Resources.getResource("json/vehicle_history.json"), Charsets.UTF_8)
        val gson = Gson()
        val jsonString = gson.toJson(jsonStringResponse)
        val listType = object : TypeToken<VehicleHistoryPojo>() { }.type
        val response = gson.fromJson<VehicleHistoryPojo>(jsonString, listType)
        return Single.just(response)
    }

    override fun parseVehicleRatingHtmlResponse(baseUrl: String, vehicleRatingHtmlString: String): Single<VehicleRatingSummaryPojo> {
        val jsonStringResponse = Resources.toString(Resources.getResource("json/vehicle_rating_summary.json"), Charsets.UTF_8)
        val gson = Gson()
        val jsonString = gson.toJson(jsonStringResponse)
        val listType = object : TypeToken<VehicleRatingSummaryPojo>() { }.type
        val response = gson.fromJson<VehicleRatingSummaryPojo>(jsonString, listType)
        return Single.just(response)
    }
}*/