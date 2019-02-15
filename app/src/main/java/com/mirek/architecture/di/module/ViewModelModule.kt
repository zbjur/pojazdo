package com.mirek.architecture.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.mirek.architecture.di.ViewModelFactory
import com.mirek.architecture.di.ViewModelKey
import com.mirek.architecture.ui.aztecscanner.VehicleScannerViewModel
import com.mirek.architecture.ui.summary.VehicleSumaryViewModel
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
    @ViewModelKey(VehicleSumaryViewModel::class)
    abstract fun bindsSummaryViewModel(vehicleSumaryViewModel: VehicleSumaryViewModel): ViewModel
}