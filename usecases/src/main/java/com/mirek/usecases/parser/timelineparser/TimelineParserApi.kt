package com.mirek.usecases.parser.timelineparser

import com.mirek.usecases.parser.timelineparser.model.Timeline
import org.jsoup.nodes.Document

interface TimelineParserApi {

    fun parseTimeLine(doc: Document) : Timeline
}