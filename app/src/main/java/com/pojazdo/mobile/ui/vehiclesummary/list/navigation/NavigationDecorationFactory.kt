package com.pojazdo.mobile.ui.vehiclesummary.list.navigation

import com.pojazdo.mobile.di.DaggerNamedConstants
import javax.inject.Inject
import javax.inject.Named

class NavigationDecorationFactory @Inject constructor(@Named(DaggerNamedConstants.DETAILS) private val detailsNavigationStrategy: DetailsFragmentStrategy,
                                                      @Named(DaggerNamedConstants.RATING) private val ratingNavigationStrategy: RatingFragmentStrategy,
                                                      @Named(DaggerNamedConstants.COMMENTS) private val userCommentsFragmentStrategy: UserCommentsFragmentStrategy,
                                                      @Named(DaggerNamedConstants.CONTACT) private val contactDetailsNavigationStrategy: ContactDetailsFragmentStrategy) : INavigationDecorationFactory {

    override fun generateNavigationStrategy(navigationType: NavigationType?) =
            when (navigationType) {
                NavigationType.DETAILS -> detailsNavigationStrategy
                NavigationType.RATING -> ratingNavigationStrategy
                NavigationType.COMMENTS -> userCommentsFragmentStrategy
                else -> contactDetailsNavigationStrategy
            }
}

enum class NavigationType {
    DETAILS,
    RATING,
    COMMENTS,
    CONTACT
}