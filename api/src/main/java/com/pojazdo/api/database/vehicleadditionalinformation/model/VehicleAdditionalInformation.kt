package com.pojazdo.api.database.vehicleadditionalinformation.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehicle_additional_information_table")
class VehicleAdditionalInformation(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        val vehicleId: Int? = null,
        val brand: String,
        val model: String,
        val year: String,
        val vin: String,
        val firstRegistrationDate: String,
        val vehiclePrice: Double = 0.0,
        val registrationNumber: String)