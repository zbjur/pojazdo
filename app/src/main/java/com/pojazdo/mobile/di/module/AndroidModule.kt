package com.pojazdo.mobile.di.module

import com.pojazdo.mobile.ui.vehiclesummary.VehicleSummaryActivity
import com.pojazdo.mobile.ui.vehiclesummary.fragments.VehicleSummaryFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidModule {

    @ContributesAndroidInjector
    abstract fun contributeActivityInjector(): VehicleSummaryActivity

    @ContributesAndroidInjector
    abstract fun contributeFragmentInjector(): VehicleSummaryFragment
}