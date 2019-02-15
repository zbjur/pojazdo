package com.mirek.usecases.parser.maininfoparser

import com.mirek.usecases.parser.maininfoparser.model.VehicleInfo
import org.jsoup.nodes.Document

interface MainInfoParserApi {
    fun parseVehicleMainInfo(doc: Document): VehicleInfo
}