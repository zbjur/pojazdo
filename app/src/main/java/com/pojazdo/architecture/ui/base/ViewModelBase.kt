package com.pojazdo.architecture.ui.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.pojazdo.architecture.ui.Event

open class ViewModelBase : ViewModel() {
    val viewState = MutableLiveData<Event<Command>>()

    public fun hideProgress() { viewState.postValue(Event(Command.HideProgress())) }

    public fun showProgress() { viewState.postValue(Event(Command.ShowProgress())) }
}