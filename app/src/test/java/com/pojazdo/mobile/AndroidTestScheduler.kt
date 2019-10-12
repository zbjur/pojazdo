package com.pojazdo.mobile

import com.mobile.base.AndroidScheduler
import io.reactivex.*
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import io.reactivex.schedulers.TestScheduler
import java.util.concurrent.TimeUnit

class AndroidTestScheduler @JvmOverloads constructor(private val observing: Scheduler = Schedulers.trampoline(),
                                                     private val executing: Scheduler = Schedulers.trampoline(),
                                                     private val testScheduler: TestScheduler = TestScheduler()) : AndroidScheduler(observing, executing) {


    override fun <C> scheduleContinuouslyWithDelay(single: Single<C>,
                                                   onNextAction: Consumer<C>,
                                                   onErrorAction: Consumer<Throwable>,
                                                   onTickAction: Action,
                                                   intervalSeconds: Int,
                                                   subscriber: Any,
                                                   initialDelayInSeconds: Int) {
        val intervalObservable = Observable
                .interval(initialDelayInSeconds.toLong(), intervalSeconds.toLong(), TimeUnit.SECONDS, testScheduler)
                .observeOn(testScheduler)
                .subscribeOn(testScheduler)
                .doOnNext { onTickAction.run() }
                .flatMap { single.toObservable() }

        schedule(
                intervalObservable,
                onNextAction,
                onErrorAction,
                subscriber)
    }

    override fun disposeFor(subscriber: Any): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun subscribeOnScheduler(): Scheduler {
        return executing
    }

    override fun observeOnScheduler(): Scheduler {
        return observing
    }

    override fun periodicScheduler(): Scheduler {
        return executing
    }
}
