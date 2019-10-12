package com.pojazdo.mobile.ui.vehiclesummary.list

import com.github.vivchar.rendererrecyclerviewadapter.CompositeViewRenderer
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter
import com.pojazdo.mobile.ui.vehiclesummary.list.category.CategoryViewRenderer
import com.pojazdo.mobile.ui.vehiclesummary.list.category.FooterViewRenderer
import com.pojazdo.mobile.ui.vehiclesummary.list.list.RecyclerViewRenderer
import com.pojazdo.mobile.ui.vehiclesummary.list.map.MapViewRenderer
import com.pojazdo.mobile.ui.vehiclesummary.list.rating.RatingViewRenderer
import com.pojazdo.mobile.ui.vehiclesummary.list.rating.UserCommentsViewRenderer
import com.pojazdo.mobile.ui.vehiclesummary.list.rating.VehicleAveragePriceViewRenderer
import com.pojazdo.mobile.ui.vehiclesummary.list.saleoffers.VehicleSaleOffersViewRenderer
import com.pojazdo.mobile.ui.vehiclesummary.list.sellerdetails.SellerDetailsViewRenderer
import com.pojazdo.mobile.ui.vehiclesummary.list.timeline.VehicleTimeLineViewRenderer
import com.pojazdo.mobile.ui.vehiclesummary.list.vehiclesummary.VehicleSummaryViewRenderer
import javax.inject.Inject

class ViewRendererFactory @Inject constructor(private val vehicleAveragePriceViewRenderer: VehicleAveragePriceViewRenderer,
                                              private val categoryViewRenderer: CategoryViewRenderer,
                                              private val userCommentsViewRenderer: UserCommentsViewRenderer,
                                              private val footerViewRenderer: FooterViewRenderer,
                                              private val recyclerViewRenderer: RecyclerViewRenderer,
                                              private val mapViewRenderer: MapViewRenderer,
                                              private val ratingViewRenderer: RatingViewRenderer,
                                              private val vehicleSaleOffersViewRenderer: VehicleSaleOffersViewRenderer,
                                              private val sellerDetailsViewRenderer: SellerDetailsViewRenderer,
                                              private val timeLineViewRenderer: VehicleTimeLineViewRenderer,
                                              private val vehicleSummaryViewRenderer: VehicleSummaryViewRenderer) {

    fun bindViewRenderer(mRecyclerViewAdapter: RendererRecyclerViewAdapter) {
        mRecyclerViewAdapter.registerRenderer(vehicleSummaryViewRenderer)
        mRecyclerViewAdapter.registerRenderer(footerViewRenderer)
        mRecyclerViewAdapter.registerRenderer(categoryViewRenderer)
        mRecyclerViewAdapter.registerRenderer(timeLineViewRenderer)
        mRecyclerViewAdapter.registerRenderer(ratingViewRenderer)
        mRecyclerViewAdapter.registerRenderer(userCommentsViewRenderer)
        mRecyclerViewAdapter.registerRenderer(vehicleAveragePriceViewRenderer)
        mRecyclerViewAdapter.registerRenderer(createListRenderer()
                .registerRenderer(vehicleSaleOffersViewRenderer))
        mRecyclerViewAdapter.registerRenderer(sellerDetailsViewRenderer)
        mRecyclerViewAdapter.registerRenderer(mapViewRenderer)
    }

    private fun createListRenderer(): CompositeViewRenderer<*, *> {
        return RecyclerViewRenderer()
    }
}