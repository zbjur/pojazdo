package com.pojazdo.api.database.vehicleadditionalinformation.database

import androidx.room.*
import com.pojazdo.api.database.vehicleadditionalinformation.model.Seller
import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAdditionalInformation
import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAndSellerInformation
import io.reactivex.Single

@Dao
interface VehicleInformationDAO {

    @Transaction
    fun insertOrUpdate(vehicleAdditionalInformation: VehicleAdditionalInformation) {
        if (getVehicleInformation(vehicleAdditionalInformation.vin) == null)
            insertVehicleAdditionalInformation(vehicleAdditionalInformation)
        else update(vehicleAdditionalInformation)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertVehicleAdditionalInformation(vehicleAdditionalInformation: VehicleAdditionalInformation)

    @Update
    fun update(vehicleAdditionalInformation: VehicleAdditionalInformation)

    @Query("DELETE FROM vehicle_additional_information_table WHERE vin = :vin")
    fun delete(vin: String)

    @Query("SELECT * FROM vehicle_additional_information_table WHERE vin = :vin")
    fun getVehicleInformation(vin: String): VehicleAdditionalInformation

    @Query("SELECT * from vehicle_additional_information_table")
    fun getAllVehicleInformation(): List<VehicleAdditionalInformation>

    @Insert
    fun updateSeller(seller: Seller)

    /**
     * This query will tell Room to query both the [VehicleAdditionalInformation] and [Seller] tables and handle
     * the object mapping.
     */

    @Query("SELECT * FROM vehicle_additional_information_table WHERE vin = :vin")
    fun loadVehiclesInfo(vin: String): Single<VehicleAndSellerInformation>

    @Query("SELECT * FROM vehicle_additional_information_table")
    fun loadAllVehiclesInfo(): Single<List<VehicleAndSellerInformation>>
}