package com.example.rxjavaplaystation.emittertypes

import android.os.Bundle
import com.example.rxjavaplaystation.BaseActivity
import io.reactivex.rxjava3.core.Flowable
import timber.log.Timber

class RxFlowableActivity: BaseActivity() {
    /**
     * There are other types of emitter than Observable.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Flowable is exactly like Observable but supports back pressure
        Flowable.just("This is a flowable")
            .subscribe(
                {value-> Timber.d("Received : $value")},
                {error-> Timber.d("Error: $error")},
                {Timber.d("Completed")}
            )
    }
}