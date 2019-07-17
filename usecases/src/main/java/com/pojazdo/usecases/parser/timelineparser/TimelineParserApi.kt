package com.pojazdo.usecases.parser.timelineparser

import com.pojazdo.usecases.parser.timelineparser.model.Timeline
import org.jsoup.nodes.Document

interface TimelineParserApi {

    fun parseTimeLine(doc: Document) : Timeline
}