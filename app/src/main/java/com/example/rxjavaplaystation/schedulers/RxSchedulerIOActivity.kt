package com.example.rxjavaplaystation.schedulers

import android.os.Bundle
import com.example.rxjavaplaystation.BaseActivity
import io.reactivex.rxjava3.core.Flowable.just
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber

class RxSchedulerIOActivity: BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * Scheduler.io() This is the most common types of Scheduler that are used. They’re generally used for IO related stuff, such as network requests, file system operations, and it’s backed by a thread pool. A Java Thread Pool represents a group of worker threads that are waiting for the job and reuse many times.
         */
        Observable.just("Apple","Orange","Banana")
                .subscribeOn(Schedulers.io())
                .subscribe{ item-> Timber.d("Received : $item")}
    }


}