package com.example.rxjavaplaystation.emittertypes

import android.os.Bundle
import com.example.rxjavaplaystation.BaseActivity
import io.reactivex.rxjava3.core.Single
import timber.log.Timber
import java.lang.RuntimeException

class RxSingleActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Emits only sole/single item
        // http://reactivex.io/documentation/operators.html#tree

        /**
         * see the subscribe method parameter, onSuccess instead of onNext
         * Notice that there is no more onNext and onComplete and a
         * new notification onSuccess is defined. This makes sense because a Single only emits a single item,
         * hence it can be interpreted as onNext and onComplete at the same time.
         * If we use this class and there is a value emitted, onSuccess will be called.
         * If there’s no value, onError will be called.
         */
        Single.just("Single Item")
            .subscribe(
                { item ->
                    Timber.d("First : Value is : $item")
                },
                { error ->
                    Timber.e("First : Error : $error")
                }
            )

        Single.error<Throwable>(RuntimeException())
            .subscribe(
                { item ->
                    Timber.d("Second : Value is : $item")
                },
                { error ->
                    Timber.e("Second : Error : $error")
                }
            )
    }
}