package com.mirek.usecases.html

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import pl.droidsonroids.jspoon.ElementConverter
import pl.droidsonroids.jspoon.annotation.Selector

class CarConverter : ElementConverter<String> {
    override fun convert(node: Element, selector: Selector): String {
        return node.html()
    }
}
