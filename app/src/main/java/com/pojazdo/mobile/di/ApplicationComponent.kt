package com.pojazdo.mobile.di

import com.pojazdo.mobile.di.module.*
import com.pojazdo.mobile.ui.PojazdoApplication
import com.pojazdo.mobile.ui.form.FormFragment
import com.pojazdo.mobile.ui.vehiclesummary.VehicleSummaryActivity
import com.pojazdo.mobile.ui.vehiclesummary.editseller.EditSellerDataFragment
import com.pojazdo.mobile.ui.vehiclesummary.fragments.UserCommentsFragment
import com.pojazdo.mobile.ui.vehiclesummary.fragments.VehicleDetailsFragment
import com.pojazdo.mobile.ui.vehiclesummary.fragments.VehicleLocationActivity
import com.pojazdo.mobile.ui.vehiclesummary.fragments.VehicleSummaryFragment
import com.pojazdo.mobile.ui.vehiclesummary.fragments.UserRatingFragment
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    AndroidModule::class,
    ViewModelModule::class,
    ServiceModule::class,
    ConverterModule::class,
    NetworkModule::class,
    DatabaseModule::class,
    NavigationModule::class,
    ViewRenderModule::class])
interface ApplicationComponent : AndroidInjector<AndroidModule> {
    fun inject(application: PojazdoApplication)
    fun inject(summaryActivity: VehicleSummaryActivity)
    fun inject(vehicleLocationActivity: VehicleLocationActivity)
    fun inject(formFragment: FormFragment)
    fun inject(editSellerFragment: EditSellerDataFragment)
    fun inject(vehicleSummaryFragment: VehicleSummaryFragment)
    fun inject(userCommentsFragment: UserCommentsFragment)
    fun inject(userRatingFragment: UserRatingFragment)
    fun inject(vehicleDetailsFragment: VehicleDetailsFragment)
}
