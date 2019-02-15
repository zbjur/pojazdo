package com.mirek.architecture.html

interface ParserInvoker<T> {
    fun parseHtmlStuff(inputString: String): T
}