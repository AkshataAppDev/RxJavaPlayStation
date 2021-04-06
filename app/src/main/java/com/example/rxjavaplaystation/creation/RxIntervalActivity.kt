package com.example.rxjavaplaystation.creation

import android.os.Bundle
import com.example.rxjavaplaystation.BaseActivity
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import timber.log.Timber
import java.util.concurrent.TimeUnit

class RxIntervalActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//        Observable.intervalRange(
//            10L, //Start
//        5L, //Count
//        0L, // Initial DL
//        1L, // Period
//        TimeUnit.SECONDS
//        ).subscribe{ Timber.d("Result we just received : $it")}

        /**
         * OUTPUT :
        Result we just received: 10
        Result we just received: 11
        Result we just received: 12
        Result we just received: 13
        Result we just received: 14
         */

        Observable.interval(1000, TimeUnit.MILLISECONDS)
            .subscribe{Timber.d("Result we just received : $it")}


    }
}