package com.pojazdo.usecases.parser

import com.pojazdo.usecases.parser.model.VehicleReport

interface VehicleReportParserApi {
    fun parseVehicleReport(html: String): VehicleReport
}