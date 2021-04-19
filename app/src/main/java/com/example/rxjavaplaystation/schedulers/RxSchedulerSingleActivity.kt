package com.example.rxjavaplaystation.schedulers

import android.os.Bundle
import com.example.rxjavaplaystation.BaseActivity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber

class RxSchedulerSingleActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        var array = mutableListOf<String>( "Paris")

        // no matter how many observable single will run on single thread
        Observable.fromArray(array)
                .subscribeOn(Schedulers.single())
                .subscribe { Timber.d("Received 1 : $it on thread ${Thread.currentThread().name}") }

        Observable.fromArray(array)
                .subscribeOn(Schedulers.single())
                .subscribe { Timber.d("Received 2 : $it on thread ${Thread.currentThread().name}") }
    }
}