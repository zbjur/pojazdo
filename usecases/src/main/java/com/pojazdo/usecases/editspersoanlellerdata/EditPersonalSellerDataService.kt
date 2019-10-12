package com.pojazdo.usecases.editspersoanlellerdata

import com.pojazdo.api.database.vehicleadditionalinformation.DatabasePersistenceApi
import com.pojazdo.api.database.vehicleadditionalinformation.model.Seller
import io.reactivex.Single
import javax.inject.Inject

class EditPersonalSellerDataService @Inject constructor(private val databasePersistenceApi: DatabasePersistenceApi) : EditPersonalSellerDataApi {

    override fun editPersonalSellerData(seller: Seller): Single<Seller> {

        return Single.just(Seller(1,"Zbigniew","Juroszek","535353","Goleszów","Zniwna","",0.0,0.0))
    }

    override fun removePersonalSellerData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}