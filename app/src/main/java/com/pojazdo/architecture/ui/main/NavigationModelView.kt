package com.pojazdo.architecture.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NavigationModelView : ViewModel() {

    val launchDestination: MutableLiveData<Void> = MutableLiveData()

    fun replaceView() {
        launchDestination.postValue(null)
    }

}