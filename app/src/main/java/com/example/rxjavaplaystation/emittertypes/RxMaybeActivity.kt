package com.example.rxjavaplaystation.emittertypes

import android.os.Bundle
import com.example.rxjavaplaystation.BaseActivity
import io.reactivex.rxjava3.core.Maybe
import timber.log.Timber
import java.lang.RuntimeException

class RxMaybeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /** Maybe is similar to Single
         * This class is used when you’d like to return a single optional value.
         * The methods are mutually exclusive, in other words, only one of them is called.
         * If there is an emitted value, it calls onSuccess , if there’s no value, it calls onComplete or
         * if there’s an error, it calls onError . Maybe allows no emission at all.
         */

        /**
         * see the subscribe method parameter, onSuccess instead of onNext
         * Notice that there is no more onNext and onComplete and a
         * new notification onSuccess is defined.
         * */

        // onReceive

        Maybe.just("This is Maybe")
            .subscribe(
                { value -> Timber.d("First : Received: $value") },
                { error -> Timber.d("First : Error: $error") },
                { Timber.d("First : Completed") }
            )

        //onComplete
        Maybe.empty<String>()
            .subscribe(
                { value -> Timber.d("Second : Received: $value") },
                { error -> Timber.d("Second : Error: $error") },
                { Timber.d("Second : Completed") }
            )


        //onError
        Maybe.error<Throwable>(RuntimeException())
            .subscribe(
                { value -> Timber.d("Third : Received: $value") },
                { error -> Timber.d("Third : Error: $error") },
                { Timber.d("Third : Completed") }
            )
    }
}