package com.pojazdo.api.database.vehicleadditionalinformation.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAdditionalInformation

@Database(entities = [VehicleAdditionalInformation::class], version = 3)
abstract class VehicleDatabase : RoomDatabase() {
    abstract fun vehicleInformationDao(): VehicleInformationDAO

}