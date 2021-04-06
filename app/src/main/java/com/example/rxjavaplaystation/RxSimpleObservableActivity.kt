package com.example.rxjavaplaystation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.rxjava3.core.Observable
import java.util.*

class RxSimpleObservableActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Observable.just("Hello Reactive World !!")
                .subscribe{ value-> println(value)}
    }
}