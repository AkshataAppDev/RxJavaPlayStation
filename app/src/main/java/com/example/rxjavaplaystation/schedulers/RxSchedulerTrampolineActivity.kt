package com.example.rxjavaplaystation.schedulers

import android.app.Activity
import android.os.Bundle
import com.example.rxjavaplaystation.BaseActivity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber

class RxSchedulerTrampolineActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // trampoline will run on whateber current thread is
        // if current thread is main, it will run the code on queue of main thread
        // Similar to immediate scheduler it blocks the thread.
        // It maybe used when we have more than one Observable and want to execute them in order

        var array1 = mutableListOf<String>("Paris", "Barcelona", "Amsterdam")
        var array2 = mutableListOf<String>("Milan", "Toronto", "Sydney")
        Observable.fromArray(array1)
                .subscribeOn(Schedulers.trampoline())
                .subscribe {
                    Timber.d("1 Received  $it on thread ${Thread.currentThread().name}")
                }
        Observable.fromArray(array2)
                .subscribeOn(Schedulers.trampoline())
                .subscribe {
                    Timber.d("2 Received $it on thread ${Thread.currentThread().name}")
                }


        // Other Schedulers:
        // AndroidSchedulers.mainThread()
        //

    }
}