package com.pojazdo.mobile.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pojazdo.mobile.ui.Event

open class ViewModelBase : ViewModel() {
    val viewState = MutableLiveData<Event<Command>>()

    public fun hideProgress() { viewState.postValue(Event(Command.HideProgress)) }

    public fun showProgress() { viewState.postValue(Event(Command.ShowProgress)) }
}