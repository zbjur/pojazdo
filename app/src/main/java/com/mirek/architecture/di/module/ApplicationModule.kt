package com.mirek.architecture.di.module

import android.content.Context
import com.mirek.architecture.ui.MirekApplication
import com.mobile.base.AndroidScheduler
import com.mobile.base.ApplicationScheduler
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module
open class ApplicationModule(private val application: MirekApplication) {

    @Singleton
    @Provides
    open fun provideApplicationContext(): Context = application

      @Singleton
      @Provides
      open fun providesAndroidScheduler(): ApplicationScheduler = AndroidScheduler(AndroidSchedulers.mainThread(), Schedulers.io())
}
