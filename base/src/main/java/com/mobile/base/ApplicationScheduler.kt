package com.mobile.base

import io.reactivex.*
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer

interface ApplicationScheduler {

    fun <C> schedule(single: Single<C>, onNextAction: Consumer<C>, onErrorAction: Consumer<Throwable>)

    fun <C> schedule(observable: Observable<C>,
                     onNextAction: Consumer<C>,
                     onErrorAction: Consumer<Throwable>,
                     subscriber: Any)

    fun <C> schedule(flowable: Flowable<C>,
                     onNextAction: Consumer<C>,
                     onErrorAction: Consumer<Throwable>,
                     subscriber: Any)

    fun schedule(completable: Completable,
                 onNextAction: Action,
                 onErrorAction: Consumer<Throwable>,
                 subscriber: Any)

    fun <C> scheduleOnMainThread(observable: Observable<C>,
                                 onNextAction: Consumer<C>,
                                 onErrorAction: Consumer<Throwable>,
                                 subscriber: Any)



    fun <C> scheduleContinuouslyWithDelay(single: Single<C>,
                                          onNextAction: Consumer<C>,
                                          onErrorAction: Consumer<Throwable>,
                                          onTickAction: Action,
                                          intervalSeconds: Int,
                                          subscriber: Any,
                                          initialDelayInSeconds: Int)

    fun invokeActionWithDelay(onNextAction: Consumer<Long>,
                              intervalSeconds: Long,
                              subscriber: Any)

    fun disposeFor(subscriber: Any): Int

    fun subscribeOnScheduler(): Scheduler

    fun observeOnScheduler(): Scheduler

    fun periodicScheduler(): Scheduler

}