package com.example.rxjavaplaystation.schedulers

import android.os.Bundle
import com.example.rxjavaplaystation.BaseActivity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber

class RxSchedulerNewThreadActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // starts new thread everytime it is requested on subscribeOn or observOn()

        Observable.just("Hello")
                .observeOn(Schedulers.newThread())
                .doOnNext{
                    Timber.d(" doOnNext :  $it on thread ${Thread.currentThread().name}") // thread 1
                }
                .observeOn(Schedulers.newThread())
                .subscribe{
                    Timber.d("Received : $it on thread ${Thread.currentThread().name}") // thread 2
                }
    }
}