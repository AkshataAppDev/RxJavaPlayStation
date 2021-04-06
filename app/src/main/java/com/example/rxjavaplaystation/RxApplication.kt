package com.example.rxjavaplaystation

import android.app.Application
import timber.log.Timber

class RxApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}