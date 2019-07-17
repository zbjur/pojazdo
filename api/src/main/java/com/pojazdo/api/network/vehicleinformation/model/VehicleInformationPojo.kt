package com.pojazdo.api.network.vehicleinformation.model
import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2019 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class VehicleInformationPojo (

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
        @SerializedName("technicalDataPojo") val technicalDataPojo : TechnicalDataPojo?,
        @SerializedName("documentsPojo") val documentsPojo : DocumentsPojo?,
        @SerializedName("timeLinePojo") val timeLinePojo : List<TimeLinePojo>?,
        @SerializedName("vehicleRatingPojo") val vehicleRatingPojo : VehicleRatingPojo?,
        @SerializedName("vehicleOffersPojo") val vehicleOffersPojo : VehicleOffersPojo?
)