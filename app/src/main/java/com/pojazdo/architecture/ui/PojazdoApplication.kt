package com.pojazdo.architecture.ui

import android.app.Application
import com.pojazdo.architecture.di.ApplicationComponent
import com.pojazdo.architecture.di.module.ApplicationModule
import com.pojazdo.architecture.di.DaggerApplicationComponent

class PojazdoApplication : Application() {

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
        this.initializeLeakDetection()
    }

    private fun injectMembers() = appComponent.inject(this)

    private fun initializeLeakDetection() {

    }
}