package com.pojazdo.usecases.editspersoanlellerdata

import com.pojazdo.api.database.vehicleadditionalinformation.model.Seller
import io.reactivex.Single

interface EditPersonalSellerDataApi {

    fun editPersonalSellerData(seller : Seller): Single<Seller>

    fun removePersonalSellerData()
}