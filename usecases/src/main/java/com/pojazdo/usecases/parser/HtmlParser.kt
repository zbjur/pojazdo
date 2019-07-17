package com.pojazdo.usecases.parser

import org.jsoup.nodes.Element

class HtmlParser : HtmlParserApi  {



     override fun removeParagrafTag(input: String): String {
        val s = input.replace("<p>", "")
        return s.replace("</p>", "")
    }

    override fun removeStrongTag(input: String): String {
        val s = input.replace("<strong>", "")
        return s.replace("</strong>", "")
    }


    private fun hasElementId(row: Element, id: String) = row.getElementById(id).hasText()

    private fun hasElementClass(row: Element, className: String) = row.getElementsByClass(className).hasText()
}