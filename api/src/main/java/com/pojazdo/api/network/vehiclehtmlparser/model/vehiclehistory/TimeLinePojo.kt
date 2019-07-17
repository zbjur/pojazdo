package com.pojazdo.api.network.vehiclehtmlparser
import com.google.gson.annotations.SerializedName

data class TimeLinePojo (
	@SerializedName("Key") val Key : String,
	@SerializedName("value") val value : String,
	@SerializedName("timeLinePojo") val timeLinePojo : List<TimeLinePojo>
)