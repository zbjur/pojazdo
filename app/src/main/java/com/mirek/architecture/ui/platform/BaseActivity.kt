package com.mirek.architecture.ui.platform

import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import com.mirek.architecture.di.ApplicationComponent
import com.mirek.architecture.ui.MirekApplication
import com.mirek.architecture.ui.application.Navigator
import javax.inject.Inject

abstract class  BaseActivity : AppCompatActivity () {

    abstract fun layoutId(): Int

    val appComponent: ApplicationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as MirekApplication).appComponent
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var navigator : Navigator


}