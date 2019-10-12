package com.pojazdo.mobile.di.module

import android.content.Context
import com.mobile.base.AndroidScheduler
import com.mobile.base.ApplicationScheduler
import com.pojazdo.mobile.ui.PojazdoApplication
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module
open class ApplicationModule(private val application: PojazdoApplication) {

    @Singleton
    @Provides
    open fun provideApplicationContext(): Context = application

    @Singleton
    @Provides
    open fun providesAndroidScheduler(): ApplicationScheduler = AndroidScheduler(AndroidSchedulers.mainThread(), Schedulers.io())
}
