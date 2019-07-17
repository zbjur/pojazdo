package com.mobile.htmlparser

import pl.droidsonroids.jspoon.annotation.Selector
import java.util.*


class VehicleResponse {
    @Selector("#marka")
    val marka : String = String()
    @Selector("#typ")
    val typ : String = String()
    @Selector("#model")
    val model : String = String()

   /* @Selector("#title") String title;
    @Selector("li.") List<Integer> intList;
    @Selector(value = "#image1", attr = "src") String imageSource;*/
    /*<section class="raport-header">
    /*
    String htmlContent =
    "<div>"
    + "<p id='title'>Title</p>"
    + "<ul>"
    + "<li class='a'>1</li>"
    + "<li>2</li>"
    + "<li class='a'>3</li>"
    + "</ul>"
    + "<img id='image1' src='image.bmp' />"
    + "</div>";
    */

    <div class="group   -text"><p class="name">
    <span id="marka">FSO</span>,
    <span  id="typ">polonez</span>,
    <span class="uppercase" id="model">caro 1.6</span>
    <div class="raport-main-information">
    <h1>RAPORT PRZYKŁADOWY</h1>
    <div class="car-details">
    <div class="group   -text"><p class="name">
    <span class="uppercase" id="marka">FSO</span>,
    <span class="uppercase" id="typ">polonez</span>,
    <span class="uppercase" id="model">caro 1.6</span>
    </p>
    <p class="typ"><span
    class="lowercase"
    id="rodzaj">samochód osobowy</span>,
    <span class="lowercase"
    id="podrodzaj">hatchback</span>
    </p>
    <p class="engine"><span
    id="pojemnosc">1598&nbsp;cm³</span>,
    <span class="lowercase"
    id="paliwo">Benzyna bezołowiowa</span>
    </p></div>
    <div class="group-text data"><p>Rok
    produkcji: <span class="strong"
    id="rokProdukcji">1981</span>
    </p>
    <p>VIN: <span
    class="uppercase strong">SUP4RA1R5BJ312970</span>
    </p>
    <p>Polisa OC: <span class="strong">brak informacji o aktualnej polisie</span>
    </p>
    <p>Badanie techniczne:<span
    class="strong"> aktualne</span>
    </p>
    <p>Ostatni zarejestrowany stan
    licznika: <span class="strong"
    id="aktualnyStanLicznika">523 000</span><span
    class="strong"
    id="jednostkaLicznika">&nbsp;km</span>
    </p>
    <p>Status rejestracji: <span
    class="lowercase strong">Zarejestrowany</span>
    </p>
    <p class="stolen"><strong>Pojazd
    oznaczony w ewidencji jako
    kradziony!</strong></p></div>
    </div>
    </div>
    </section>
    </div>
    </section>*/
    @Selector("li.a")
    var intList: List<Int>? = null
}
