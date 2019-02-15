package com.mirek.usecases.parser.maininfoparser

import com.mirek.usecases.parser.maininfoparser.model.VehicleInfo
import org.jsoup.nodes.Document

class MainInfoParserService : MainInfoParserApi {
    override fun parseVehicleMainInfo(doc: Document) = VehicleInfo()
}