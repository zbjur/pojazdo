package com.pojazdo.usecases.parser.maininfoparser

import com.pojazdo.usecases.parser.maininfoparser.model.VehicleInfo
import org.jsoup.nodes.Document

interface MainInfoParserApi {
    fun parseVehicleMainInfo(doc: Document): VehicleInfo
}