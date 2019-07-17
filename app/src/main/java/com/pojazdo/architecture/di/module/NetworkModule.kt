package com.pojazdo.architecture.di.module

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.pojazdo.architecture.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {
    companion object {
        const val CONNECTION_TIMEOUT_IN_SECONDS = 30L
        const val SOCKET_READ_TIMEOUT_IN_SECONDS = 30L
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {

        return OkHttpClient.Builder().apply {
            connectTimeout(CONNECTION_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            if (BuildConfig.DEBUG) {
                addInterceptor(StethoInterceptor())
                addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            } else {
                readTimeout(SOCKET_READ_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
            }
        }.build()
    }
}