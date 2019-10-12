package com.pojazdo.mobile.ui

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.pojazdo.mobile.di.ApplicationComponent
import com.pojazdo.mobile.di.DaggerApplicationComponent
import com.pojazdo.mobile.di.module.ApplicationModule
import com.pojazdo.mobile.di.module.DatabaseModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class PojazdoApplication : Application(), HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var dispatchingFragmentInjector: DispatchingAndroidInjector<Fragment>

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .databaseModule(DatabaseModule(this))
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        this.injectMembers()
        this.initializeLeakDetection()
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingFragmentInjector

    private fun injectMembers() = appComponent.inject(this)

    private fun initializeLeakDetection() {

    }
}