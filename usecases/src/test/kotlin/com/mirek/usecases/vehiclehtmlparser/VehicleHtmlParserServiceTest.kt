package com.mirek.usecases.vehiclehtmlparser

import com.nhaarman.mockito_kotlin.mock
import org.junit.Test

import org.junit.Assert.*

class VehicleHtmlParserServiceTest {



    val VehicleHtmlParserApi : VehicleHtmlParserApi = mock {
        on { decodeAztecCode()}
    }

    @Test
    fun decodeAztecCode() {
    }
}