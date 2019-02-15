package com.mirek.usecases.parser

import com.mirek.usecases.parser.maininfoparser.model.Vehicle
import com.mirek.usecases.parser.maininfoparser.model.VehicleInfo
import com.mirek.usecases.parser.model.VehicleReport
import com.mirek.usecases.parser.timelineparser.model.Timeline

object VehicleReportParserFactory {

    fun makeVehicle() = Vehicle(
            brand = "Skoda",
            model = "Roomster",
            yearOfProduction = "2011",
            engine = "benzine",
            insurance = "yes",
            vin = "121313"
    )

    fun makeTimeLine() = Timeline()

    fun makeVehicleInfo() : VehicleInfo{
        val vehicleInfo = VehicleInfo()
        vehicleInfo?.brand = "Skoda"
        vehicleInfo?.model = "Roomster"
        vehicleInfo?.vin = "R4242"

        return vehicleInfo
    }

    fun makeVehicleReport() = VehicleReport()
}
