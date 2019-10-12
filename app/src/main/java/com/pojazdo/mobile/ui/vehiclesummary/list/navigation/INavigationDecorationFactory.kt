package com.pojazdo.mobile.ui.vehiclesummary.list.navigation

interface INavigationDecorationFactory {
    fun generateNavigationStrategy(navigationType: NavigationType?): FragmentNavigationStrategy
}