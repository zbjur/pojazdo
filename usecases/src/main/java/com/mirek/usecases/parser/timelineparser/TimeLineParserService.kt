package com.mirek.usecases.parser.timelineparser

import com.mirek.usecases.parser.timelineparser.model.Timeline
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class TimeLineParserService : TimelineParserApi{

    override fun parseTimeLine(document: Document)  = Timeline()

    private fun parseHeader(table: Element, rowNum: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun parseBody(table: Element, rowNum: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun parseFooter(table: Element, rowNum: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

/*
    fun parseTable(doc: Document) {
        val table = doc.getElementById("timeline")
        var rowNum = 0
        parseProduction(table, rowNum)
    }
*/

/*    fun parseProduction(table: Element, rowNum: Int) {
        var rowNum1 = rowNum
        for (row in table.select("> thead > tr")) {
            if (row.getElementById("production").hasText()) {
                val production = row.getElementById("production")
                System.out.println("row $row")
            }
            // parseRow(rowNum1++, row)
        }
    }

    override fun parseEvents(html: String) {
        val doc = Jsoup.parse(html)
        val table = doc.getElementById("timeline")
        var rowNum = 0
        var rowNum1 = rowNum
        for (row in table.select("> tbody > tr")) {
            if (row.getElementById("event").hasText()) {
                val production = row.getElementsByClass("event")
                System.out.println("row $row")
            }
            parseRow(rowNum1++, row)
        }
    }

    fun parseRow(rowNum: Int, row: Element) {
        var columnNum = 0
        for (cell in row.select("> th")) {
            System.out.println("cell $cell")
            val data = cell.getElementsByClass("date").get(0).html()
            val opis = cell.getElementsByClass("description").get(0).html()

        }
    }*/

}