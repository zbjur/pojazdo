package com.pojazdo.usecases.parser.timelineparser

import com.pojazdo.usecases.parser.timelineparser.model.Event
import com.pojazdo.usecases.parser.timelineparser.model.Timeline
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class TimeLineParserService : TimelineParserApi {

    companion object {
        const val TIMELINE = "timeline"
        const val PRODUCTION = "production"
        const val EVENT = "event"
        const val DATE = "date"
        const val DESCRIPTION = "description"
        const val KEY = "key"
        const val VALUE = "value"
    }

    override fun parseTimeLine(document: Document): Timeline {
        val table = document.getElementById(TIMELINE)
        val eventHeader = parseHeader(table)
        return Timeline(eventHeader)
    }

    private fun parseHeader(table: Element): List<Event> {

        var events: MutableList<Event> = mutableListOf()

        for (row in table.select("> thead > tr")) {
            if (hasElementId(row, PRODUCTION)) {
                events.add(parseTimeLineHeader(row))
            }
        }
        for (row in table.select("> tbody > tr")) {
            if (row.getElementsByClass(EVENT).hasText()) {
                val bodyEvents = parseTimeLineBody(row)
                events.addAll(bodyEvents)
            }
        }
        return events
    }

    private fun hasElementId(row: Element, id: String) = row.getElementById(id).hasText()

    private fun parseTimeLineHeader(row: Element) =
            row.getElementById(PRODUCTION)
                    .let { Event(it.getElementsByClass(DATE).text(),
                                it.getElementsByClass(DESCRIPTION).text()) }

    private fun parseTimeLineBody(row: Element) =
            row.getElementsByClass(EVENT)
                    .filter { it.getElementsByClass(DATE).hasText() &&
                                it.getElementsByClass(DESCRIPTION).hasText() }
                    .map { getSubEvent(it) }

    private fun getSubEvent(it: Element) =
            Event(it.getElementsByClass(DATE).text(), "",
                    it.getElementsByClass(DESCRIPTION)
                            ?.flatMap { it -> getSubEventList(it.children()) })

    private fun getSubEventList(elements: Elements) =
            elements.filter {
                it.getElementsByClass(KEY).hasText() &&
                        it.getElementsByClass(VALUE).hasText() }
                    .map { parseSubEvent(it) }

    private fun parseSubEvent(it: Element) =
            Event(it.getElementsByClass(KEY).text(),
                    it.getElementsByClass(VALUE).text())
}