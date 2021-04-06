package com.example.rxjavaplaystation

import android.os.Bundle
import io.reactivex.rxjava3.core.Observable

import timber.log.Timber

class RxOnXMethodActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         * it may call onNext zero or more times, and then may follow those calls with a call to either onCompleted or onError but not both,
         * which will be its last call. By convention, in this document, calls to onNext are usually called “emissions” of items, whereas calls
         * to onCompleted or onError are called “notifications.”
         */
        Observable.just("Apple", "Orange", "Banana")
            .subscribe(
                { value -> Timber.d("Received: $value") }, // onNext - called when Observable emits an item
                { error -> Timber.e("Error: $error") }, // onError - called when observable fails to generate expected data and it will not make further
                //calls to onNext, onCompleted or onError
                { Timber.d("OnComplete") } //onComplete - called after onNext has been called for final time it it did not encounter any errors.
            )

    }
}