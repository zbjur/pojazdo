package com.mirek.architecture.html

import com.mirek.api.network.htmlparser.model.VehicleInfo
import pl.droidsonroids.jspoon.Jspoon

class ParserInvokerImpl : ParserInvoker<VehicleInfo> {

    override fun parseHtmlStuff(htmlContent: String): VehicleInfo {
        val jspoon = Jspoon.create()
        val htmlAdapter = jspoon.adapter(VehicleInfo::class.java)
        return htmlAdapter.fromHtml(htmlContent)
    }
}