package com.example.rxjavaplaystation.creation

import android.os.Bundle
import com.example.rxjavaplaystation.BaseActivity
import io.reactivex.rxjava3.core.Observable
import timber.log.Timber

class RxFromActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // fromArray
        Observable.fromArray("Paris", "Rome", "Tokyo")
            .subscribe { Timber.d("Received : $it") }


        //fromIterable

        Observable.fromIterable(listOf("Switzerland", "Norway", "Iceland"))
            .subscribe(
                { value -> Timber.d("Received : $value") },
                { error -> Timber.e("Error: $error") },
                { Timber.d("OnCompleted") }
            )
    }
}