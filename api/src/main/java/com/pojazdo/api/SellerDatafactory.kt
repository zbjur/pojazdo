package com.pojazdo.api

import com.pojazdo.api.database.vehicleadditionalinformation.model.Seller

object SellerDatafactory {

    fun makeSeller() = Seller(1, "Zbigniew", "Juroszek", "683745345", "Goleszów", "Zniwna 4", "z.sds@gss.pl", 0.0, 0.0)
}