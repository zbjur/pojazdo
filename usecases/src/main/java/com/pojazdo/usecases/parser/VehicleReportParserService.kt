package com.pojazdo.usecases.parser

import com.pojazdo.usecases.parser.maininfoparser.MainInfoParserApi
import com.pojazdo.usecases.parser.model.VehicleReport
import com.pojazdo.usecases.parser.timelineparser.TimelineParserApi
import org.jsoup.Jsoup
import javax.inject.Inject

class VehicleReportParserService @Inject constructor(private val mainInfoParserApi: MainInfoParserApi,
                                                     private val timelineParserApi: TimelineParserApi
) : VehicleReportParserApi {

    override fun parseVehicleReport(html: String): VehicleReport {
        val doc = Jsoup.parse(html)
        val vehicleInfo = mainInfoParserApi.parseVehicleMainInfo(doc)
        val timeline = timelineParserApi.parseTimeLine(doc)
        return VehicleReport(vehicleInfo,timeline)
    }
}

