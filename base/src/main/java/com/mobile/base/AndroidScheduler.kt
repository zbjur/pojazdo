package com.mobile.base

import io.reactivex.*
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer

open class AndroidScheduler constructor(private val observingScheduler: Scheduler,
                                        private val executingScheduler: Scheduler) : ApplicationScheduler {

    override fun <C> schedule(single: Single<C>, onNextAction: Consumer<C>, onErrorAction: Consumer<Throwable>) {
           single
                .subscribeOn(observingScheduler)
                .observeOn(executingScheduler)
                   .subscribe(onNextAction,onErrorAction)
    }


    override fun <C> schedule(observable: Observable<C>, onNextAction: Consumer<C>, onErrorAction: Consumer<Throwable>, subscriber: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <C> schedule(flowable: Flowable<C>, onNextAction: Consumer<C>, onErrorAction: Consumer<Throwable>, subscriber: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun schedule(completable: Completable, onNextAction: Action, onErrorAction: Consumer<Throwable>, subscriber: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <C> scheduleOnMainThread(observable: Observable<C>, onNextAction: Consumer<C>, onErrorAction: Consumer<Throwable>, subscriber: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <C> scheduleContinuouslyWithDelay(single: Single<C>, onNextAction: Consumer<C>, onErrorAction: Consumer<Throwable>, onTickAction: Action, intervalSeconds: Int, subscriber: Any, initialDelayInSeconds: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun invokeActionWithDelay(onNextAction: Consumer<Long>, intervalSeconds: Long, subscriber: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun disposeFor(subscriber: Any): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun subscribeOnScheduler(): Scheduler {
        return executingScheduler
    }

    override fun observeOnScheduler(): Scheduler {
        return observingScheduler
    }

    override fun periodicScheduler(): Scheduler {
        return executingScheduler
    }
}

