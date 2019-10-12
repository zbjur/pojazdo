package com.pojazdo.mobile.ui.platform

import androidx.lifecycle.ViewModelProvider
import androidx.appcompat.app.AppCompatActivity
import com.pojazdo.mobile.di.ApplicationComponent
import com.pojazdo.mobile.ui.PojazdoApplication
import com.pojazdo.mobile.ui.application.Navigator
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