package com.example.rxjavaplaystation.emittertypes

import android.os.Bundle
import com.example.rxjavaplaystation.BaseActivity
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observers.DisposableCompletableObserver
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber
import java.lang.RuntimeException
import java.util.concurrent.TimeUnit


class RxCompletableActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // doesnt emit any data
        // if successfull calls onComplete
        // if error calls onError
        //By using Completable we agree to ignore the onNext event and only handle onComplete and onError.
        /**
         * A completable won’t emit any data, what it does is let you know whether the operation was successfully completed.
         * If it was, it calls onComplete and if it wasn’t it calls onError .
         * A common use case of completable is for REST APIs, where successful access will return HTTP 204 , and errors can
         * ranger from HTTP 301 , HTTP 404 , HTTP 500 , etc. We might do something with the information.
         */
        val d: Disposable = Completable.error(RuntimeException())
            .delay(5, TimeUnit.SECONDS, Schedulers.io())
            .subscribeWith(object : DisposableCompletableObserver() {
                override fun onStart() {
                    Timber.d("Started")
                }

                override fun onError(error: Throwable) {
                  Timber.e("Error $error")
                }

                override fun onComplete() {
                    Timber.d("Done!")
                }
            })
        d.dispose()
    }
}