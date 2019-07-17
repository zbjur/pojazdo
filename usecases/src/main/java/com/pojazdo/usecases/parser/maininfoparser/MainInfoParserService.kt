package com.pojazdo.usecases.parser.maininfoparser

import com.pojazdo.usecases.parser.maininfoparser.model.VehicleInfo
import org.jsoup.nodes.Document

class MainInfoParserService : MainInfoParserApi {
    override fun parseVehicleMainInfo(doc: Document) = VehicleInfo()
}