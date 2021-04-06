package com.example.rxjavaplaystation.creation

import android.os.Bundle
import com.example.rxjavaplaystation.BaseActivity
import io.reactivex.rxjava3.core.Observable

class RxSimpleObservableActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Observable.just("Hello Reactive World !!")
                .subscribe{ value-> println(value)}
    }
}