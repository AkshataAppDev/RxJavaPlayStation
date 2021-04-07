package com.example.rxjavaplaystation.creation

import android.os.Bundle
import com.example.rxjavaplaystation.BaseActivity
import io.reactivex.rxjava3.core.Observable
import timber.log.Timber
import java.lang.Exception

class RxCreateActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getObservableFromList(listOf("Pasta","Paratha","Misal"))
            .subscribe { Timber.d("Received: $it") }


        //Will only return Pasta and terminate with an exception bcz of blank string
        //getObservableFromList(listOf("Pasta","","Misal"))
        //  .subscribe { Timber.d("Received: $it") }

    }

    fun getObservableFromList(myList: List<String>) =


        /**
         * Create - create an observable from scratch by calling observer methods programmatically
         */
        Observable.create<String> { emitter ->
            myList.forEach { kind ->

                if (kind == "") {
                    emitter.onError(Exception("There's no value"))
                }
                emitter.onNext(kind)

            }
            emitter.onComplete()
        }
}