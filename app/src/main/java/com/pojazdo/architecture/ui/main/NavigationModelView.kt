package com.pojazdo.architecture.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class NavigationModelView : ViewModel() {

    val launchDestination: MutableLiveData<Void> = MutableLiveData()

    fun replaceView() {
        launchDestination.postValue(null)
    }

}