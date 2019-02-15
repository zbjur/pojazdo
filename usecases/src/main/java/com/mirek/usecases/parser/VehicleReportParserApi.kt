package com.mirek.usecases.parser

import com.mirek.usecases.parser.model.VehicleReport

interface VehicleReportParserApi {
    fun parseVehicleReport(html: String): VehicleReport
}