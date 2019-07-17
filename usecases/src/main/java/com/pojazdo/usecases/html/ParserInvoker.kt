package com.pojazdo.architecture.html

interface ParserInvoker<T> {
    fun parseHtmlStuff(inputString: String): T
}