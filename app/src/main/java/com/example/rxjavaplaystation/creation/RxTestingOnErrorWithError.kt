package com.example.rxjavaplaystation.creation

import android.os.Bundle
import com.example.rxjavaplaystation.BaseActivity
import io.reactivex.rxjava3.core.Observable
import timber.log.Timber
import java.lang.RuntimeException


class RxTestingOnErrorWithError : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Observable.just("Apple", "Orange", "Banana")
            .map { input ->
                throw RuntimeException()
            }
            .subscribe(
                { value -> Timber.d("Received : $value") },
                { error -> Timber.e("Error: $error") },
                { Timber.d("Completed !") })
    }

}