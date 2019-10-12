package com.pojazdo.api.database.vehicleadditionalinformation.database

import androidx.room.*
import com.pojazdo.api.database.vehicleadditionalinformation.model.Seller
import io.reactivex.Single

@Dao
interface SellerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSeller(seller: Seller)

    @Update
    fun updateSeller(seller: Seller)

    @Query("SELECT * FROM seller WHERE vehicle_id = :vehicleId")
    fun getSeller(vehicleId: Int): Single<Seller>

    @Delete
    fun delete(seller: Seller)
}