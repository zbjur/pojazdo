package com.pojazdo.api.network.vehicleinformation.model
import com.google.gson.annotations.SerializedName
import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAdditionalInformation
import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAndSellerInformation
import com.pojazdo.api.network.vehicleinformation.model.*


class VehicleInformation constructor(

        @SerializedName("brand") val brand: String,
        @SerializedName("model") val model: String,
        @SerializedName("yearOfProduction") val yearOfProduction: Int,
        @SerializedName("vin") val vin: String,
        @SerializedName("engineCapacity") val engineCapacity: String,
        @SerializedName("insurance") val insurance: String,
        @SerializedName("technicalExamination") val technicalExamination: String,
        @SerializedName("lastMeterState") val lastMeterState: String,
        @SerializedName("registrationState") val registrationState: String,
        @SerializedName("fuel") val fuel: String,
        @SerializedName("alternativeFuel") val alternativeFuel: String,
        @SerializedName("technicalData") val technicalData: TechnicalData,
        @SerializedName("documents") val documents: Documents,
        @SerializedName("timeLine") val timeLine: List<TimeLine>,
        @SerializedName("vehicleRating") val vehicleRating: VehicleRating,
        @SerializedName("vehicleAveragePrice") val vehicleAveragePrice: VehicleAveragePrice,
        @SerializedName("vehicleOffers") val vehicleOffers: List<VehicleOffers>)
{
    var vehicleAndSellerInformation: VehicleAndSellerInformation? = null
}