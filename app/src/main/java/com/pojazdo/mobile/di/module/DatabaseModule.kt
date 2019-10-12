package com.pojazdo.mobile.di.module

import androidx.room.Room
import com.pojazdo.api.database.vehicleadditionalinformation.database.SellerDAO
import com.pojazdo.api.database.vehicleadditionalinformation.database.VehicleDatabase
import com.pojazdo.api.database.vehicleadditionalinformation.database.VehicleInformationDAO
import com.pojazdo.mobile.ui.PojazdoApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class DatabaseModule(private val application: PojazdoApplication) {

    @Singleton
    @Provides
    fun provideVehicleDatabase(): VehicleDatabase {
        return  Room.databaseBuilder(application, VehicleDatabase::class.java!!, "VehicleDatabase")
                .fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    fun provideVehicleDao(vehicleDatabase: VehicleDatabase): VehicleInformationDAO {
        return vehicleDatabase.vehicleInformationDao()
    }

    @Provides
    fun provideSellerDao(vehicleDatabase: VehicleDatabase): SellerDAO {
        return vehicleDatabase.sellerDao()
    }
}
