package com.pojazdo.mobile.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pojazdo.mobile.di.ViewModelFactory
import com.pojazdo.mobile.di.ViewModelKey
import com.pojazdo.mobile.ui.aztecscanner.VehicleScannerViewModel
import com.pojazdo.mobile.ui.vehiclesummary.VehicleInformationViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(VehicleScannerViewModel::class)
    abstract fun bindsMovieDetailsViewModel(movieDetailsViewModel: VehicleScannerViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(VehicleInformationViewModel::class)
    abstract fun bindsSummaryViewModel(vehicleInformationViewModel: VehicleInformationViewModel): ViewModel
}