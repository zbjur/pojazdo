package com.pojazdo.api.database.vehicleadditionalinformation.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vehicle_additional_information_table")

 class VehicleAdditionalInformation(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "vin")
        val vin: String,
        val firstRegistrationDate: String,
        val registrationNumber: String,
        val latitiude: Double? = null,
        val longtitiude: Double? = null,
        val city: String? = null,
        val street: String? = null,
        val email: String? = null,
        val phoneNumber: String? = null)
