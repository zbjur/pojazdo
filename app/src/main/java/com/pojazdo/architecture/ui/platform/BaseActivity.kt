package com.pojazdo.architecture.ui.platform

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import com.pojazdo.architecture.di.ApplicationComponent
import com.pojazdo.architecture.ui.PojazdoApplication
import com.pojazdo.architecture.ui.application.Navigator
import javax.inject.Inject

abstract class  BaseActivity : AppCompatActivity () {

    abstract fun layoutId(): Int

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as PojazdoApplication).appComponent
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var navigator : Navigator


}