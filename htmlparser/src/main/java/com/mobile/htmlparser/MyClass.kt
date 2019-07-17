package com.mobile.htmlparser

import pl.droidsonroids.jspoon.HtmlAdapter
import pl.droidsonroids.jspoon.Jspoon



class MyClass{

    var html: String = "String htmlContent =\n" +
            "    \"<div>\"\n" +
            "    + \"<p id='title'>Title</p>\"\n" +
            "    + \"<ul>\"\n" +
            "    + \"<li class='a'>1</li>\"\n" +
            "    + \"<li>2</li>\"\n" +
            "    + \"<li class='a'>3</li>\"\n" +
            "    + \"</ul>\"\n" +
            "    + \"<img id='image1' src='image.bmp' />\"\n" +
            "    + \"</div>\";"


    fun parseMyHtml(){



    }

}