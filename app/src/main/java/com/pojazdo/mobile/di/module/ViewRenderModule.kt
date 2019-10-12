package com.pojazdo.mobile.di.module

import com.github.vivchar.rendererrecyclerviewadapter.CompositeViewRenderer
import com.pojazdo.mobile.ui.vehiclesummary.list.ViewRendererFactory
import com.pojazdo.mobile.ui.vehiclesummary.list.category.CategoryViewRenderer
import com.pojazdo.mobile.ui.vehiclesummary.list.category.FooterViewRenderer
import com.pojazdo.mobile.ui.vehiclesummary.list.list.RecyclerViewRenderer
import com.pojazdo.mobile.ui.vehiclesummary.list.map.MapViewRenderer
import com.pojazdo.mobile.ui.vehiclesummary.list.navigation.*
import com.pojazdo.mobile.ui.vehiclesummary.list.rating.RatingViewRenderer
import com.pojazdo.mobile.ui.vehiclesummary.list.rating.UserCommentsViewRenderer
import com.pojazdo.mobile.ui.vehiclesummary.list.rating.VehicleAveragePriceViewRenderer
import com.pojazdo.mobile.ui.vehiclesummary.list.saleoffers.VehicleSaleOffersViewRenderer
import com.pojazdo.mobile.ui.vehiclesummary.list.sellerdetails.SellerDetailsViewRenderer
import com.pojazdo.mobile.ui.vehiclesummary.list.timeline.VehicleTimeLineViewRenderer
import com.pojazdo.mobile.ui.vehiclesummary.list.vehiclesummary.VehicleSummaryViewRenderer
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewRenderModule {

    @Singleton
    @Provides
    fun createNavigationDecorationFactory(detailsNavigationStrategy: DetailsFragmentStrategy,
                                          ratingNavigationStrategy: RatingFragmentStrategy,
                                          userCommentsFragmentStrategy: UserCommentsFragmentStrategy,
                                          contactDetailsNavigationStrategy: ContactDetailsFragmentStrategy) = NavigationDecorationFactory(
            detailsNavigationStrategy,
            ratingNavigationStrategy,
            userCommentsFragmentStrategy,
            contactDetailsNavigationStrategy)

    @Singleton
    @Provides
    fun createViewRendererFactory(vehicleAveragePriceViewRenderer: VehicleAveragePriceViewRenderer,
                                  categoryViewRenderer: CategoryViewRenderer,
                                  userCommentsViewRenderer: UserCommentsViewRenderer,
                                  footerViewRenderer: FooterViewRenderer,
                                  recyclerViewRenderer: RecyclerViewRenderer,
                                  mapViewRenderer: MapViewRenderer,
                                  ratingViewRenderer: RatingViewRenderer,
                                  vehicleSaleOffersViewRenderer: VehicleSaleOffersViewRenderer,
                                  sellerDetailsViewRenderer: SellerDetailsViewRenderer,
                                  timeLineViewRenderer: VehicleTimeLineViewRenderer,
                                  vehicleSummaryViewRenderer: VehicleSummaryViewRenderer) = ViewRendererFactory(
            vehicleAveragePriceViewRenderer,
            categoryViewRenderer,
            userCommentsViewRenderer,
            footerViewRenderer,
            recyclerViewRenderer,
            mapViewRenderer,
            ratingViewRenderer,
            vehicleSaleOffersViewRenderer,
            sellerDetailsViewRenderer,
            timeLineViewRenderer,
            vehicleSummaryViewRenderer)

    @Singleton
    @Provides
    fun createVehicleAveragePriceViewRenderer() = VehicleAveragePriceViewRenderer()

    @Singleton
    @Provides
    fun categoryViewRenderer() = CategoryViewRenderer()

    @Singleton
    @Provides
    fun createFooterViewRenderer(navigationDecorationFactory: NavigationDecorationFactory) = FooterViewRenderer(navigationDecorationFactory)

    @Singleton
    @Provides
    fun createRecyclerViewRenderer(): CompositeViewRenderer<*, *> = RecyclerViewRenderer()

    @Singleton
    @Provides
    fun createMapViewRenderer() = MapViewRenderer()

    @Singleton
    @Provides
    fun createRatingViewRenderer() = RatingViewRenderer()

    @Singleton
    @Provides
    fun createVehicleSaleOffersViewRenderer() = VehicleSaleOffersViewRenderer()

    @Singleton
    @Provides
    fun createSellerDetailsViewRenderer() = SellerDetailsViewRenderer()

    @Singleton
    @Provides
    fun createVehicleTimeLineViewRenderer() = VehicleTimeLineViewRenderer()

    @Singleton
    @Provides
    fun createVehicleSummaryViewRenderer() = VehicleSummaryViewRenderer()

    @Singleton
    @Provides
    fun createUserCommentsViewRenderer() = UserCommentsViewRenderer()
}