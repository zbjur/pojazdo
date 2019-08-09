package com.pojazdo.api.database.vehicleadditionalinformation.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAdditionalInformation

@Dao
interface VehicleInformationDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vehicleAdditionalInformation: VehicleAdditionalInformation)

    @Insert
    fun update(vehicleAdditionalInformation: VehicleAdditionalInformation)

    @Query("DELETE FROM vehicle_additional_information_table WHERE vin = :vin")
    fun delete(vin: String)

    @Query("SELECT * FROM vehicle_additional_information_table WHERE vin = :vin")
    fun getVehicleInformation(vin: String): VehicleAdditionalInformation

    @Query("SELECT * from vehicle_additional_information_table")
    fun getAllVehicleInformation(): List<VehicleAdditionalInformation>
}