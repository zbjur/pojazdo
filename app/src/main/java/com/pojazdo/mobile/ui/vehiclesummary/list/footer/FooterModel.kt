package com.pojazdo.mobile.ui.vehiclesummary.list.category

import com.github.vivchar.rendererrecyclerviewadapter.ViewModel
import com.pojazdo.mobile.ui.vehiclesummary.list.navigation.NavigationType

data class FooterModel(val name: String, val navigationType: NavigationType? = null) : ViewModel

