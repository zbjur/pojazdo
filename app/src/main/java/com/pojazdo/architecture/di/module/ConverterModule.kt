package com.pojazdo.architecture.di.module

import com.pojazdo.usecases.vehicleInformation.converter.VehicleInformationConverter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ConverterModule {

    @Provides
    @Singleton
    fun provideVehicleConverter() = VehicleInformationConverter ()
}