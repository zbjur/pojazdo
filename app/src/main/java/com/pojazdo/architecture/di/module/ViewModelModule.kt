package com.pojazdo.architecture.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.pojazdo.architecture.di.ViewModelFactory
import com.pojazdo.architecture.di.ViewModelKey
import com.pojazdo.architecture.ui.aztecscanner.VehicleScannerViewModel
import com.pojazdo.architecture.ui.summary.VehicleInformationViewModel
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