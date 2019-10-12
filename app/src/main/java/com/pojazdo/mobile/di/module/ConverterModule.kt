package com.pojazdo.mobile.di.module


import com.pojazdo.mobile.ui.vehiclesummary.converter.VehicleInformationConverter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ConverterModule {

    @Provides
    @Singleton
    fun provideVehicleConverter() = VehicleInformationConverter ()
}