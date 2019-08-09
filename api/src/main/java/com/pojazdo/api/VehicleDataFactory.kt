package com.pojazdo.api

import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAdditionalInformation
import com.pojazdo.api.network.vehicleinformation.model.*

object VehicleDataFactory {

/*    *//*Vehicle Information*//*
    val brand = "Skoda"
    val model = "Roomster"
    val yearOfProduction = 2011
    val vin = "TMBNC25J7C7016783"
    val capacity = "1,4"
    val insurance = "aktualna"
    val technicalExamination = "aktualne"
    val lastMeterState = "145 294 km "
    val registrationState = "zarejestrowany"
    val fuel = "beznyzna"
    val alternativeFuel = "gaz"

    val engineCapacity = "1,4"
    val enginePower = "64 kW"
    val fuelType = "benzyna bezołowiowa"
    val coEmEmission = "210 g/km"
    val averageFuelCnsumption = "9 l"

    *//*overall rating*//*
    val overallRating = "3,90"
    val overallTitle = "średnia ocena z 213 ocen"
    val buyAgainPercentage = "69%"
    val buyAgainTitle = "użytkowników kupiłoby ponownie"

    *//*rating *//*
    val title = "Całokształt"
    val rating = "3,90"
    val ratingUrl = "https://www.autocentrum.pl/oceny/skoda/roomster/mikrovan/silnik-diesla-1.9-tdi-105km-2006-2010/"

    *//*engineRating rating*//*
    val engineName: String = "1.2 12V 70KM 51kW"
    val engineRating: String = "3,90"
    val engineUrlRating: String = "https://www.autocentrum.pl/oceny/skoda/roomster/mikrovan/silnik-diesla-1.9-tdi-105km-2006-2010/"

    *//*user rating *//*
    val userRating = "4,1"
    val user = "~andrzej"
    val ratedModel = "Skoda Roomster"
    val type = "Mikrovan 1.4 TDI 80KM 59kW"
    val comment = "Skodą Roomster 1.4 tdi jeżdżę ponad 6 lat." +
            " Przejechałem około 50000 tyś. kilometrów. Uważam że jest to bardzo praktyczny, tani w eksploatacji i niezawodny pojazd. Wnętrze zaprojektowane" +
            " dla rodziny z dwojgiem niedużych dzieci lub dla małej firmy. Fotele łatwo się wyciąga i mamy ogromną przestrzeń bagażową. Wygodna pozycja za kierownicą.Dużo miejsca z przodu. " +
            "Dobre fabryczne radio z możliwością połączenia z telefonem. Ogromny rynek tanich..."


    *//*Car offer*//*
    val price = "219900"
    val priceCurrency = "PLN"
    val url = "https://www.otomoto.pl/oferta/porsche-911-carrera-targa-3-6-boxer-320km-salon-pl-ID6BRkuy.html#2e83b13067"

    val offerType = "Car"
    val offerName = "Porsche Cayenne"
    val vehicleConfiguration = "Porsche Cayenne 3.0D 245KM Panorama, FV23%"
    val offerBrand = "Porsche"
    val offerFuelType = "Diesel"
    val modelDate = "2013"
    val unitCode = "KMT"
    val value = "57900"


    fun createVehicleAdditionalInformation() = VehicleAdditionalInformation(vin, "2011.02.13", "SCI 315")

    fun createVehicleInformationPojo() = VehicleInformation(
            brand = brand,
            model = model,
            yearOfProduction = yearOfProduction,
            vin = vin,
            engineCapacity = engineCapacity,
            insurance = insurance,
            technicalExamination = technicalExamination,
            lastMeterState = lastMeterState,
            registrationState = registrationState,
            fuel = fuel,
            alternativeFuel = alternativeFuel,
            technicalData = makeTechnicalInfomatio(),
            documents = makeVehicleDocuments(),
            timeLine = makeVehicleTimeLine(),
            vehicleRating = makeVehicleRatings(),
            vehicleOffers = makeVehicleOffers(),
            vehicleAveragePrice = makeVehicleAveragePrice())

    fun makeTechnicalInfomatio() = TechnicalData(
            engineCapacity = engineCapacity,
            enginePower = enginePower,
            fuelType = fuelType,
            coEmEmission = coEmEmission,
            averageFuelConsumption = averageFuelCnsumption)

    fun makeVehicleDocuments() = Documents(engineCapacity = engineCapacity)

    fun makeVehicleTimeLine(): MutableList<TimeLine> {
        return mutableListOf(TimeLine("12.03.2019", "Rodzaj badania: okresowe", listOf(TimeLine("Właściciel:", "Osoba fizyczna"))), TimeLine("Województwo, w którym pojazd zarejestrowano:", "warmińsko-mazurskie"),
                TimeLine("12.03.2017", "Rodzaj badania: okresowe", listOf(TimeLine("12.03.2017", ""))))
    }

    fun makeVehicleRatings() = VehicleRating(overallRating, overallTitle, buyAgainPercentage, buyAgainTitle, makeVehicleRating(), makeVehicleEngineRating(), makeUserVehicleRating())

    fun makeVehicleRating() =  mutableListOf<Ratings>(
            Ratings("Silnik","2.4","jakims tam url"),
            Ratings("Skrzynia biegów","4.4","jakims tam url"),
            Ratings("Układ jezdny","6.4","jakims tam url"),
            Ratings("Karosieria","5.4","jakims tam url"),
            Ratings("Widoczność","5.4","jakims tam url"),
            Ratings("Ergonomia","5.4","jakims tam url"),
            Ratings("Koszty utrzymania","5.4","jakims tam url"),
            Ratings("Karosieria","5.4","jakims tam url")
    )

    fun makeVehicleEngineRating() =  mutableListOf<EngineRating>(
            EngineRating("Diesel","2.4","jakims tam url"),
            EngineRating("Benzyna","4.4","jakims tam url"),
            EngineRating("Diesel","6.4","jakims tam url"),
            EngineRating("Benzyna","5.4","jakims tam url")

    )

    fun makeUserVehicleRating() = mutableListOf<UserRatings>(
            UserRatings("3.4","tomek","Skoda Roomste","MIKROVAN","Auto bardzo pakowne, zwrotne i jak na ilość miejsca w środku, bardzo łatwe do parkowania. Świetne rozwiązanie z wyjmowanymi fotelami z tyłu!"),
            UserRatings("2.4","romek","Skoda Roomste","MIKROVAN","mamy wersje praha wiec jast wszystko skora szklany dach klimatrinik doswietlanie zakretow i duzo wiecej jak narazie jast tanszy w eksploatacji niz nasze poprzednie auto. zona jast zadowolona"),
            UserRatings("7.4","franek","Skoda Roomste","MIKROVAN","auto jest idealne dla rodziny z dwojgiem dzieci ,przy trujce ciut mało miejsca na 3 foteliki z tyłu,poza tym sprawuje się rewelacyjnie na karzdej nawieszchni ,jest pakowny i dynamiczny nawet przy pełnym załadunku gorąco polecam zakup tego modelu skody ,sam czekam na nowszy model roomstera ktury ma wyjćś w 2014 roku."),
            UserRatings("3.4","zygmunt","Skoda Roomste","MIKROVAN","Auto bardzo pakowne, zwrotne i jak na ilość miejsca w środku, bardzo łatwe do parkowania. Świetne rozwiązanie z wyjmowanymi fotelami z tyłu!"),
            UserRatings("1.4","Ernesto","Skoda Roomste","MIKROVAN","Auto bardzo pakowne, zwrotne i jak na ilość miejsca w środku, bardzo łatwe do parkowania. Świetne rozwiązanie z wyjmowanymi fotelami z tyłu!"))
    fun makeEngineVehicleRating() = null
    fun makeVehicleOffers() = null
    fun makeVehicleAveragePrice() = null*/
}

