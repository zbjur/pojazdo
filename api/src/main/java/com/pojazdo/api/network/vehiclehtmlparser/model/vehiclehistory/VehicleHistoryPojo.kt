package com.pojazdo.api.network.vehiclehtmlparser
import com.google.gson.annotations.SerializedName

data class VehicleHistoryPojo (
		@SerializedName("brand") val brand : String,
		@SerializedName("model") val model : String,
		@SerializedName("yearOfProduction") val yearOfProduction : Int,
		@SerializedName("vin") val vin : String,
		@SerializedName("engineCapacity") val engineCapacity : String,
		@SerializedName("insurance") val insurance : String,
		@SerializedName("technicalExamination") val technicalExamination : String,
		@SerializedName("lastMeterState") val lastMeterState : String,
		@SerializedName("registrationState") val registrationState : String,
		@SerializedName("capacity") val capacity : String,
		@SerializedName("fuel") val fuel : String,
		@SerializedName("alternativeFuel") val alternativeFuel : String,
		@SerializedName("technicalDataPojo") val technicalDataPojo : TechnicalDataPojo,
		@SerializedName("documentsPojo") val documentsPojo : DocumentsPojo,
		@SerializedName("timeLinePojo") val timeLinePojo : List<TimeLinePojo>
)