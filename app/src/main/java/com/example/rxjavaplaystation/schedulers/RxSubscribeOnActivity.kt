package com.example.rxjavaplaystation.schedulers

import android.os.Bundle
import com.example.rxjavaplaystation.BaseActivity
import io.reactivex.rxjava3.core.Flowable.just
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber

class RxSubscribeOnActivity: BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Observable.just("Apple","Orange","Banana")
                .subscribeOn(Schedulers.io())
                .subscribe{ item-> Timber.d("Received : $item")}
    }


}