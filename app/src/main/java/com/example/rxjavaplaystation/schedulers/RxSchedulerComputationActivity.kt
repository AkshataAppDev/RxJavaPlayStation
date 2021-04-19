package com.example.rxjavaplaystation.schedulers

import android.os.Bundle
import com.example.rxjavaplaystation.BaseActivity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber

class RxSchedulerComputationActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * Scheduler.computation() This is quite similar to IO as it’s also backed up by the thread pool, however,
         * the number of threads that can be used is fixed to the number of cores present in the device.
         * Say you have 2 cores, it means you’ll get 2 threads, 4 cores, 4 threads, and so on.
         */
        Timber.d("Available Cores: ${Runtime.getRuntime().availableProcessors()}")

        Observable.just("Pune","Birmingham","Amsterdam")
                .subscribeOn(Schedulers.computation())
                .subscribe { Timber.d("Received : $it") }



    }
}