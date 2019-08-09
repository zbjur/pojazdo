package com.pojazdo.architecture.di.module


import com.pojazdo.architecture.ui.summary.converter.VehicleInformationConverter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ConverterModule {

    @Provides
    @Singleton
    fun provideVehicleConverter() = VehicleInformationConverter ()
}