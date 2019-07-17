package com.pojazdo.usecases.parser.timelineparser.model

data class Event(
        var key: String?, //Zmiana właściciela
        var value: String? = "", //06.07.2015
        var subEvents: List<Event?>? = listOf()) //Właściciel:  osoba fizyczna