package com.pojazdo.mobile.di.module

import com.pojazdo.mobile.di.DaggerNamedConstants
import com.pojazdo.mobile.ui.vehiclesummary.list.navigation.*
import dagger.Binds
import dagger.Module
import javax.inject.Named
import javax.inject.Singleton

@Module
abstract class NavigationModule {

    @Binds
    @Singleton
    @Named(DaggerNamedConstants.DETAILS)
    abstract fun bindsDetailsFragmentStrategy(detailsFragmentStrategy: DetailsFragmentStrategy): FragmentNavigationStrategy

    @Binds
    @Singleton
    @Named(DaggerNamedConstants.RATING)
    abstract fun bindsRatingFragmentStrategy(ratingFragmentStrategy: RatingFragmentStrategy): FragmentNavigationStrategy

    @Binds
    @Singleton
    @Named(DaggerNamedConstants.COMMENTS)
    abstract fun bindsUserCommentsFragmentStrategy(userCommentsFragmentStrategy: UserCommentsFragmentStrategy): FragmentNavigationStrategy

    @Binds
    @Singleton
    @Named(DaggerNamedConstants.CONTACT)
    abstract fun bindsContactDetailsFragmentStrategy(contactDetailsFragmentStrategy: ContactDetailsFragmentStrategy): FragmentNavigationStrategy

    /*@Binds
    @Singleton
    abstract fun bindsNavigationFactory(navigationDecorationFactory: NavigationDecorationFactory): INavigationDecorationFactory

    @Binds
    @Singleton
    abstract fun bindsViewRenderer(navigationDecorationFactory: FooterViewRenderer):ViewRenderer<FooterModel, FooterViewHolder>*/
}
