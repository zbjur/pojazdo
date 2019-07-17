package com.pojazdo.architecture.ui.summary.list

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import com.pojazdo.architecture.R
import com.pojazdo.architecture.ui.summary.list.holder.*
import com.pojazdo.architecture.ui.summary.model.*
import com.thoughtbot.expandablerecyclerview.MultiTypeExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import com.thoughtbot.expandablerecyclerview.models.ExpandableListPosition
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder


class VehicleSummaryInformationAdapter(private val ctx: Context, groups: MutableList<VehicleSections>) : MultiTypeExpandableRecyclerViewAdapter<MainSectionHolder, ChildViewHolder>(groups) {

    companion object {
        private const val VEHICLE_MAIN_INFO_VIEW_TYPE = 3
        private const val VEHICLE_TIME_LINE_VIEW_TYPE = 4
        private const val VEHICLE_RATING_VIEW_TYPE = 5
        private const val VEHICLE_AD_VIEW_TYPE = 6
        private const val VEHICLE_PRICE_OPTION_VIEW_TYPE = 7
        private const val VEHICLE_LOCATION_VIEW_TYPE = 8
    }

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateGroupViewHolder(parent: ViewGroup?, viewType: Int): MainSectionHolder {
        return MainSectionHolder(LayoutInflater.from(parent?.context).inflate(R.layout.list_item_main_section, parent, false))
    }

    override fun onCreateChildViewHolder(parent: ViewGroup?, viewType: Int): ChildViewHolder {
        return when (viewType) {
            VEHICLE_MAIN_INFO_VIEW_TYPE ->
                VehicleMainInfoHolder(LayoutInflater.from(parent?.context).inflate(R.layout.vehicle_main_info_item, parent, false))
            VEHICLE_TIME_LINE_VIEW_TYPE ->
                VehicleTimeLineHolder(LayoutInflater.from(parent?.context).inflate(R.layout.vehicle_timeline_item, parent, false))
            VEHICLE_RATING_VIEW_TYPE ->
                VehicleRatingHolder(LayoutInflater.from(parent?.context).inflate(R.layout.vehicle_rating_item, parent, false))
            VEHICLE_AD_VIEW_TYPE ->
                VehicleAdOptionsHolder(LayoutInflater.from(parent?.context).inflate(R.layout.vehicle_ad_parent_recycle, parent, false))
            VEHICLE_PRICE_OPTION_VIEW_TYPE ->
                VehiclePriceOptionsHolder(LayoutInflater.from(parent?.context).inflate(R.layout.vehicle_price_item, parent, false))
            VEHICLE_LOCATION_VIEW_TYPE ->
                VehicleLocationHolder(LayoutInflater.from(parent?.context).inflate(R.layout.vehicle_timeline_item, parent, false))
            else -> {
                VehicleTimeLineHolder(LayoutInflater.from(parent?.context).inflate(R.layout.vehicle_timeline_item, parent, false))
            }
        }
    }

    override fun onBindChildViewHolder(holder: ChildViewHolder?, flatPosition: Int, group: ExpandableGroup<*>?, childIndex: Int) {
        val viewType = getItemViewType(flatPosition)
        val vehicleSubsection = (group as VehicleSections).items[childIndex]

        when (viewType) {
            VEHICLE_MAIN_INFO_VIEW_TYPE ->
                (holder as VehicleMainInfoHolder).setVehicleMainInfo(vehicleSubsection.subsection as VehicleMainInfoSubsections)
            VEHICLE_TIME_LINE_VIEW_TYPE ->
                (holder as VehicleTimeLineHolder).setTimeLine(vehicleSubsection.subsection as VehicleTimeLine)
            VEHICLE_RATING_VIEW_TYPE ->
                (holder as VehicleRatingHolder).setRating(vehicleSubsection.subsection as VehicleRatingSection)
            VEHICLE_AD_VIEW_TYPE -> {
                (holder as VehicleAdOptionsHolder).valueTitle?.text = "Simple text"
                holder.recycleView?.layoutManager = LinearLayoutManager(holder.recycleView?.context, LinearLayout.HORIZONTAL, false)
                holder.recycleView?.adapter = VehicleAdsAdapter(ctx,( vehicleSubsection.subsection as VehicleAdSection).vehicleAds)
                holder.recycleView?.setRecycledViewPool(viewPool)

            }
            VEHICLE_PRICE_OPTION_VIEW_TYPE ->
                (holder as VehiclePriceOptionsHolder).setPrices(vehicleSubsection.subsection as VehiclePriceSection)
            VEHICLE_LOCATION_VIEW_TYPE ->
                (holder as VehicleLocationHolder).setLocation(vehicleSubsection.subsection as VehicleLocationSection)
        }
    }

    override fun onBindGroupViewHolder(holder: MainSectionHolder?, flatPosition: Int, group: ExpandableGroup<*>?) {
        holder?.genreName?.text = (group as VehicleSections).title
    }

    override fun getChildViewType(position: Int, group: ExpandableGroup<*>?, childIndex: Int): Int {
        val vehicleSubsection = (group as VehicleSections).items[childIndex]
        return when (vehicleSubsection.checkVehicleSectionType()) {
            SectionType.VehicleSectionType.VEHICLE_MAIN_INFO -> VEHICLE_MAIN_INFO_VIEW_TYPE
            SectionType.VehicleSectionType.VEHICLE_TIMELINE -> VEHICLE_TIME_LINE_VIEW_TYPE
            SectionType.VehicleSectionType.VEHICLE_ADS -> VEHICLE_AD_VIEW_TYPE
            SectionType.VehicleSectionType.VEHICLE_PRICE -> VEHICLE_PRICE_OPTION_VIEW_TYPE
            SectionType.VehicleSectionType.VEHICLE_RATING -> VEHICLE_RATING_VIEW_TYPE
            SectionType.VehicleSectionType.VEHICLE_LOCATION -> VEHICLE_LOCATION_VIEW_TYPE
        }
    }

    override fun isGroup(viewType: Int): Boolean {
        return viewType == ExpandableListPosition.GROUP
    }

    override fun isChild(viewType: Int): Boolean {
        return viewType == VEHICLE_MAIN_INFO_VIEW_TYPE ||
                viewType == VEHICLE_AD_VIEW_TYPE ||
                viewType == VEHICLE_LOCATION_VIEW_TYPE ||
                viewType == VEHICLE_PRICE_OPTION_VIEW_TYPE ||
                viewType == VEHICLE_RATING_VIEW_TYPE ||
                viewType == VEHICLE_TIME_LINE_VIEW_TYPE
    }
}