package com.mirek.usecases.html

import org.junit.Assert.assertEquals
import org.junit.Test
import pl.droidsonroids.jspoon.Jspoon
import pl.droidsonroids.jspoon.annotation.Selector


class VehicleReportParserApiInvokerImplTest {


    class BlogPage {
        @Selector(".post") lateinit var posts: List<Post>
    }

    class Post {
        @Selector(".post-content > h2 > a") lateinit var title: String
        @Selector(".excerpt") lateinit var excerpt: String
        @Selector(".post-featured-image > a > img", attr = "data-lazy-src") lateinit var imageUrl: String
        @Selector(".post-category > a") lateinit var tags: List<String>
    }

/*<span class="post-category">
<a href="*/

    class Page {
        @Selector("#title")
        var title: String? = null
        @Selector("li.a")
        var intList: List<Int>? = null
        @Selector(value = "#image1", attr = "src")
        var imageSource: String? = null

        @Selector("#_historiapojazduportlet_WAR_historiapojazduportlet_:j_idt7:marka", regex = " \bmarka\b")
        var marka: String? = null
        @Selector("span.uppercase")
        var model: String? = null

        @Selector(".post-category > a")
        var events: List<String>? = null
    }


    var htmlContent = ("<div>"
            + "<p id=\"title\">Title</p>"

            + "<span id=\"_historiapojazduportlet_WAR_historiapojazduportlet_:j_idt7:marka\" class= \"uppercase\" >SKODA</span>"
            + "<span id=\"_historiapojazduportlet_WAR_historiapojazduportlet_:j_idt7:model\" class=\"uppercase\">ROOMSTER</span>"
            + "<tr class=\"event\">\n"
            + "<td class=\"date\" scope=\"row\">"
            + "<p>\"17.10.2011\"</p>"
            + "</td> "
            + "<td class=\"description PIERWSZA_REJESTRACJA_W_POLSCE\">"
            + "<p class=\"PIERWSZA_REJESTRACJA_W_POLSCE\">"
            + "Pierwsza rejestracja w Polsce </p>"
            + "</td>"
            + "</tr>"
            + "</tr>"
            + "<ul>"
            + "<li class='a'>1</li>"
            + "<li>2</li>"
            + "<li class='a'>3</li>"
            + "</ul>"
            + "<img id='image1' src='image.bmp' />"
            + "</div>")


    @Test
    fun parseHtmlStuff() {

        val jspoon = Jspoon.create()
        val htmlAdapter = jspoon.adapter(Page::class.java)
        val page = htmlAdapter.fromHtml(htmlContent)

        assertEquals("SKODA", page.marka)
        assertEquals("Title", page.title)
        //assertEquals("1390 cm³", vehicleInfo.engineDetails?.get(0))
    }
}