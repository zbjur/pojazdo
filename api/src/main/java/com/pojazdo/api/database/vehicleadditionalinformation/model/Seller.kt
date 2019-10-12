package com.pojazdo.api.database.vehicleadditionalinformation.model

import androidx.room.*

@Entity(tableName = "seller",
        foreignKeys = [ForeignKey(
                entity = VehicleAdditionalInformation::class,
                parentColumns = arrayOf("id"),
                childColumns = arrayOf("vehicle_id"))], indices = [Index("vehicle_id")])
data class Seller(
        @ColumnInfo(name = "vehicle_id") var vehicleInfoId: Int?,
        var name: String? = "",
        var lastName: String?,
        var phoneNumber: String? = "",
        var city: String? = "",
        var street: String? = "",
        var email: String? = "",
        var latitude: Double? = 0.0,
        var longitude: Double? = 0.0) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var sellerId: Long? = 0
}