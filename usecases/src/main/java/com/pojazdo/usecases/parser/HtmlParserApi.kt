package com.pojazdo.usecases.parser

interface HtmlParserApi {

    fun removeParagrafTag(input: String): String

    fun removeStrongTag(input: String): String
}