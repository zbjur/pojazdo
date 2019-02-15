package com.mirek.architecture.di

import com.mirek.architecture.di.module.ApplicationModule
import com.mirek.architecture.di.module.NetworkModule
import com.mirek.architecture.di.module.ServiceModule
import com.mirek.architecture.di.module.ViewModelModule
import com.mirek.architecture.ui.MirekApplication
import com.mirek.architecture.ui.form.FormFragment
import com.mirek.architecture.ui.summary.SummaryActivity
import com.mirek.architecture.ui.summary.VehicleSumaryViewModel
import com.mirek.architecture.ui.summary.VehicleSummaryActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    ViewModelModule::class,
    ServiceModule::class,
    NetworkModule::class])
interface ApplicationComponent {
    fun inject(application: MirekApplication)
    fun inject(formFragment: FormFragment)
    fun inject(summaryActivity: VehicleSummaryActivity)
}
