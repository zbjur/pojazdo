package com.mirek.architecture.ui

import android.app.Application
import com.mirek.architecture.di.ApplicationComponent
import com.mirek.architecture.di.module.ApplicationModule
import com.mirek.architecture.di.DaggerApplicationComponent

class MirekApplication : Application() {

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