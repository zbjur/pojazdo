package com.pojazdo.architecture.di

import com.pojazdo.architecture.di.module.*
import com.pojazdo.architecture.ui.PojazdoApplication
import com.pojazdo.architecture.ui.form.FormFragment
import com.pojazdo.architecture.ui.summary.VehicleSummaryActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    ViewModelModule::class,
    ServiceModule::class,
    ConverterModule::class,
    NetworkModule::class,
    DatabaseModule::class])
interface ApplicationComponent {
    fun inject(application: PojazdoApplication)
    fun inject(formFragment: FormFragment)
    fun inject(summaryActivity: VehicleSummaryActivity)
}
