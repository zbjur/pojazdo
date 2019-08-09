package com.pojazdo.architecture.extension

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


inline fun <reified VM : ViewModel> androidx.fragment.app.FragmentActivity.viewModelProvider(provider: ViewModelProvider.Factory)
        = ViewModelProviders.of(this,provider).get(VM::class.java)

inline fun <reified VM : ViewModel> androidx.fragment.app.Fragment.viewModelProvider(provider: ViewModelProvider.Factory)
        = ViewModelProviders.of(this,provider).get(VM::class.java)



