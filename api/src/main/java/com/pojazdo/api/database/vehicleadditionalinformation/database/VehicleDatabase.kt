package com.pojazdo.api.database.vehicleadditionalinformation.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pojazdo.api.database.vehicleadditionalinformation.model.Seller
import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAdditionalInformation

@Database(entities = [VehicleAdditionalInformation::class, Seller::class], version = 7)
abstract class VehicleDatabase : RoomDatabase() {
    abstract fun vehicleInformationDao(): VehicleInformationDAO
    abstract fun sellerDao(): SellerDAO

}