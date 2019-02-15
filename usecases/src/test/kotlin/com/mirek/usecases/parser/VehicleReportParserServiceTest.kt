package com.mirek.usecases.parser

import com.mirek.usecases.parser.maininfoparser.MainInfoParserApi
import com.mirek.usecases.parser.timelineparser.TimelineParserApi
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class VehicleReportParserServiceTest {

    val htmlHead: String = "<table id=\"timeline\">\n" +
            "                                                <thead>\n" +
            "                                                <tr id=\"production\">\n" +
            "                                                    <th class=\"date\" scope=\"row\">\n" +
            "                                                        <strong>2011</strong></th>\n" +
            "                                                    <th class=\"axis\"><img\n" +
            "                                                            src=\"/historia-pojazdu-portlet/images/Osobowy.png\"\n" +
            "                                                            alt=\"\"></th>\n" +
            "                                                    <th class=\"description\"><strong>Rok\n" +
            "                                                        produkcji</strong></th>\n" +
            "                                                </tr>\n" +
            "                                                </thead>"


    val htmlBody: String = "<table id=\"timeline\"> <tbody>\n" +
            "                                                <tr class=\"event\">\n" +
            "                                                    <td class=\"date\" scope=\"row\"><p>17.10.2011</p>\n" +
            "                                                    </td>\n" +
            "                                                    <td class=\"axis\"><img\n" +
            "                                                            src=\"/historia-pojazdu-portlet/images/pierwszy-wlasciciel.png\"\n" +
            "                                                            alt=\"\"></td>\n" +
            "                                                    <td class=\"description PIERWSZY_WLASCICIEL\"><p\n" +
            "                                                            class=\"PIERWSZY_WLASCICIEL\">Pierwszy\n" +
            "                                                        właściciel w Polsce </p>\n" +
            "                                                        <p><span\n" +
            "                                                                class=\"wlasciciel key\">Właściciel: </span><span\n" +
            "                                                                class=\"wlasciciel prywatny value\">osoba fizyczna</span>\n" +
            "                                                        </p>\n" +
            "                                                        <p></p>\n" +
            "                                                        <p><span class=\"miejsceRejestracji key\">Województwo, w którym pojazd zarejestrowano: </span><span\n" +
            "                                                                class=\"miejsceRejestracji 28 value\">warmińsko-mazurskie</span>\n" +
            "                                                        </p>\n" +
            "                                                        <p></p></td>\n" +
            "                                                </tr></tbody>\n "


    val mockTimelineParserApi: TimelineParserApi = mock {
        on { parseTimeLine(any()) } doReturn (VehicleReportParserFactory.makeTimeLine())
    }

    val mockMainInfoParserApi: MainInfoParserApi = mock {
        on { parseVehicleMainInfo(any()) } doReturn (VehicleReportParserFactory.makeVehicleInfo())
    }

    val systemUnderTest: VehicleReportParserApi = VehicleReportParserService(mockMainInfoParserApi, mockTimelineParserApi)

    @Test
    fun parseVehicleReport() {
        val vehicleReport = systemUnderTest.parseVehicleReport(htmlHead)
        assertThat(vehicleReport.vehicle?.brand).isEqualTo("Skoda")
        assertThat(vehicleReport.vehicle?.model).isEqualTo("Roomster")
    }
}