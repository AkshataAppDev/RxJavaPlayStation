package com.example.rxjavaplaystation.creation

import android.os.Bundle
import com.example.rxjavaplaystation.BaseActivity
import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import timber.log.Timber

class RxBackPressureProblemAndSolution : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // Sample code for backpressure problem, might produce out of memory exception
//        val observable = PublishSubject.create<Int>()
//        observable.observeOn(Schedulers.computation())
//            .subscribe(
//                {
//                    Timber.d("The number is : $it")
//                },
//                { t ->
//                    Timber.e(t.message)
//                }
//            )
//
//        for (i in 0..1000000) {
//            observable.onNext(i)
//        }

        // Sample code for backpressure solution using flowable
        // Backpressure strategy DROP will drop some items in order to preserve memory capabilities
        val observable = PublishSubject.create<Int>()
        observable.toFlowable(BackpressureStrategy.DROP)
            .observeOn(Schedulers.computation())
            .subscribe(
                {
                    Timber.d("The Number is : $it")
                },
                {
                    t->
                    Timber.e(t)
                }
            )

        for(i in 0..1000000)
        {
            observable.onNext(i)
        }
    }
}