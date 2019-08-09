package com.pojazdo.architecture.ui.summary.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import com.pojazdo.architecture.R
import com.pojazdo.architecture.ui.summary.list.holder.childerholder.*
import com.pojazdo.architecture.ui.summary.list.holder.groupholder.TitleHeaderSectionHolder
import com.pojazdo.architecture.ui.summary.list.holder.groupholder.VehicleMapHolder
import com.pojazdo.architecture.ui.summary.list.holder.groupholder.VehiclePersonalDataGroupHolder
import com.pojazdo.architecture.ui.summary.list.holder.groupholder.VehicleSummaryInfoHolder
import com.pojazdo.architecture.ui.summary.model.modelsection.*
import com.pojazdo.architecture.ui.summary.model.modelsubsection.*
import com.thoughtbot.expandablerecyclerview.MultiTypeExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder

class VehicleSummaryInformationAdapter(private val ctx: Context, groups: MutableList<VehicleSections>?) : MultiTypeExpandableRecyclerViewAdapter<GroupViewHolder, ChildViewHolder>(groups) {
    override fun onExpandSelectedGroup(groupType: ExpandableGroup<*>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {

        /*GROUP'S VIEW TYPES*/
        private const val VEHICLE_REGULAR_GROUP_VIEW_TYPE = 2
        private const val VEHICLE_SUMMARY_INFO_GROUP_VIEW_TYPE = 3
        private const val VEHICLE_PERSONAL_DATA_GROUP_VIEW_TYPE = 11
        private const val VEHICLE_MAP_VIEW_TYPE = 12

        /*CHILD'S VIEW TYPES*/
        private const val VEHICLE_DETAILS_VIEW_TYPE = 4
        private const val VEHICLE_TIME_LINE_VIEW_TYPE = 5
        private const val VEHICLE_OVERALL_RATING_VIEW_TYPE = 6
        private const val VEHICLE_RATING_VIEW_TYPE = 7
        private const val VEHICLE_ENGINE_RATING_VIEW_TYPE = 8
        private const val VEHICLE_USER_RATING_VIEW_TYPE = 9
        private const val VEHICLE_AD_VIEW_TYPE = 10
        private const val VEHICLE_PRICE_OPTION_VIEW_TYPE = 11
        private const val VEHICLE_PERSONAL_DATA_CHILD_VIEW_TYPE = 14
    }

    private val viewPool = androidx.recyclerview.widget.RecyclerView.RecycledViewPool()

    override fun onCreateGroupViewHolder(parent: ViewGroup?, viewType: Int): GroupViewHolder {

        return when (viewType) {
            VEHICLE_SUMMARY_INFO_GROUP_VIEW_TYPE ->
                VehicleSummaryInfoHolder(LayoutInflater.from(parent?.context).inflate(R.layout.vehicle_summary_item, parent, false))
            VEHICLE_PERSONAL_DATA_GROUP_VIEW_TYPE ->
                VehiclePersonalDataGroupHolder(LayoutInflater.from(parent?.context).inflate(R.layout.vehicle_personal_data_group_item, parent, false))
            VEHICLE_MAP_VIEW_TYPE ->
                VehicleMapHolder(LayoutInflater.from(parent?.context).inflate(R.layout.vehicle_map_item, parent, false))
            else -> {
                TitleHeaderSectionHolder(LayoutInflater.from(parent?.context).inflate(R.layout.list_item_main_section, parent, false))
            }
        }
    }

    override fun onBindGroupViewHolder(holder: GroupViewHolder?, flatPosition: Int, group: ExpandableGroup<*>?) {
        when (getItemViewType(flatPosition)) {
            VEHICLE_SUMMARY_INFO_GROUP_VIEW_TYPE ->
                (holder as VehicleSummaryInfoHolder).setVehicleSummaryInfo(group as VehicleSummaryInfoSections)
            VEHICLE_PERSONAL_DATA_GROUP_VIEW_TYPE ->
                (holder as VehiclePersonalDataGroupHolder).setPersonalData(group as VehiclePersonalDataSection)
            VEHICLE_MAP_VIEW_TYPE ->
                (holder as VehicleMapHolder).setLocation(group as VehicleMapSection)
            else -> {
                (holder as TitleHeaderSectionHolder).setGroupTitle((group as VehicleTitleSection).title)
            }
        }
    }

    override fun onCreateChildViewHolder(parent: ViewGroup?, viewType: Int): ChildViewHolder {
        return when (viewType) {
            VEHICLE_DETAILS_VIEW_TYPE ->
                VehicleDetailsInfoHolder(LayoutInflater.from(parent?.context).inflate(R.layout.vehicle_details_item, parent, false))
            VEHICLE_TIME_LINE_VIEW_TYPE ->
                VehicleTimeLineHolder(LayoutInflater.from(parent?.context).inflate(R.layout.vehicle_timeline_item, parent, false))
            VEHICLE_OVERALL_RATING_VIEW_TYPE ->
                VehicleOverallRatingHolder(LayoutInflater.from(parent?.context).inflate(R.layout.vehicle_overall_rating, parent, false))
            VEHICLE_RATING_VIEW_TYPE ->
                VehicleRatingHolder(LayoutInflater.from(parent?.context).inflate(R.layout.vehicle_rating_item, parent, false))
            VEHICLE_ENGINE_RATING_VIEW_TYPE ->
                VehicleEngineRatingHolder(LayoutInflater.from(parent?.context).inflate(R.layout.vehicle_rating_item, parent, false))
            VEHICLE_USER_RATING_VIEW_TYPE ->
                VehicleUserRatingHolder(LayoutInflater.from(parent?.context).inflate(R.layout.vehicle_usere_rating_item, parent, false))
            VEHICLE_AD_VIEW_TYPE ->
                VehicleAdOptionsHolder(LayoutInflater.from(parent?.context).inflate(R.layout.vehicle_ad_parent_recycle, parent, false))
            VEHICLE_PRICE_OPTION_VIEW_TYPE ->
                VehiclePriceOptionsHolder(LayoutInflater.from(parent?.context).inflate(R.layout.vehicle_price_item, parent, false))
            VEHICLE_PERSONAL_DATA_CHILD_VIEW_TYPE ->
                VehiclePersonalDataChildHolder(LayoutInflater.from(parent?.context).inflate(R.layout.vehicle_personal_data_child_item, parent, false))
            else -> {
                VehicleTimeLineHolder(LayoutInflater.from(parent?.context).inflate(R.layout.vehicle_timeline_item, parent, false))
            }
        }
    }

    override fun onBindChildViewHolder(holder: ChildViewHolder?, flatPosition: Int, group: ExpandableGroup<*>?, childIndex: Int) {
        val viewType = getItemViewType(flatPosition)
        val vehicleSubsection = (group as VehicleSections).items[childIndex]

        when (viewType) {
            VEHICLE_DETAILS_VIEW_TYPE ->
                (holder as VehicleDetailsInfoHolder).setVehicleDetailsInfo(vehicleSubsection.subsection as VehicleDetailsInfoSections)
            VEHICLE_TIME_LINE_VIEW_TYPE ->
                (holder as VehicleTimeLineHolder).setTimeLine(vehicleSubsection.subsection as VehicleTimeLine)
            VEHICLE_OVERALL_RATING_VIEW_TYPE ->
                (holder as VehicleOverallRatingHolder).setOverallRating(vehicleSubsection.subsection as VehicleOverallRatingSubSection)
            VEHICLE_RATING_VIEW_TYPE ->
                (holder as VehicleRatingHolder).setRating(vehicleSubsection.subsection as VehicleRatingSubSection)
            VEHICLE_ENGINE_RATING_VIEW_TYPE ->
                (holder as VehicleEngineRatingHolder).setRating(vehicleSubsection.subsection as VehicleEngineRatingSubSection)
            VEHICLE_USER_RATING_VIEW_TYPE ->
                (holder as VehicleUserRatingHolder).setUserRating(vehicleSubsection.subsection as VehicleUserRatingSubSection)

            VEHICLE_AD_VIEW_TYPE -> {
                (holder as VehicleAdOptionsHolder).valueTitle?.text = "Simple text"
                holder.recycleView?.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(holder.recycleView?.context, LinearLayout.HORIZONTAL, false)
                holder.recycleView?.adapter = VehicleAdsAdapter(ctx, (vehicleSubsection.subsection as VehicleAdSubSection).vehicleAds)
                holder.recycleView?.setRecycledViewPool(viewPool)

            }
            VEHICLE_PRICE_OPTION_VIEW_TYPE ->
                (holder as VehiclePriceOptionsHolder).setPrices(vehicleSubsection.subsection as VehiclePriceSubSection)
            VEHICLE_PERSONAL_DATA_CHILD_VIEW_TYPE ->
                (holder as VehiclePersonalDataChildHolder).setPersonalData(vehicleSubsection.subsection as VehiclePersonalDataSubSection)
        }
    }

    override fun getGroupViewType(position: Int, group: ExpandableGroup<*>?): Int {
        return when ((group as VehicleSections).checkVehicleSectionType()) {
            SectionType.VehicleSectionType.VEHICLE_TITLE_GROUP -> VEHICLE_REGULAR_GROUP_VIEW_TYPE
            SectionType.VehicleSectionType.VEHICLE_SUMMARY_INFO_GROUP -> VEHICLE_SUMMARY_INFO_GROUP_VIEW_TYPE
            SectionType.VehicleSectionType.VEHICLE_PERSONAL_DATA_GROUP -> VEHICLE_PERSONAL_DATA_GROUP_VIEW_TYPE
            SectionType.VehicleSectionType.VEHICLE_MAP_GROUP -> VEHICLE_MAP_VIEW_TYPE
        }
    }

    override fun getChildViewType(position: Int, group: ExpandableGroup<*>?, childIndex: Int): Int {
        val vehicleSubsection = (group as VehicleSections).items[childIndex]
        return when (vehicleSubsection.checkVehicleSubSectionType()) {
            SubSectionType.VehicleSubSectionType.VEHICLE_DETAILS_INFO -> VEHICLE_DETAILS_VIEW_TYPE
            SubSectionType.VehicleSubSectionType.VEHICLE_TIMELINE -> VEHICLE_TIME_LINE_VIEW_TYPE
            SubSectionType.VehicleSubSectionType.VEHICLE_ADS -> VEHICLE_AD_VIEW_TYPE
            SubSectionType.VehicleSubSectionType.VEHICLE_PRICE -> VEHICLE_PRICE_OPTION_VIEW_TYPE
            SubSectionType.VehicleSubSectionType.VEHICLE_OVERALL_RATING -> VEHICLE_OVERALL_RATING_VIEW_TYPE
            SubSectionType.VehicleSubSectionType.VEHICLE_RATING -> VEHICLE_RATING_VIEW_TYPE
            SubSectionType.VehicleSubSectionType.VEHICLE_USER_RATING -> VEHICLE_USER_RATING_VIEW_TYPE
            SubSectionType.VehicleSubSectionType.VEHICLE_ENGINE_RATING -> VEHICLE_ENGINE_RATING_VIEW_TYPE
            SubSectionType.VehicleSubSectionType.VEHICLE_PERSONAL_DATA_CHILD -> VEHICLE_PERSONAL_DATA_CHILD_VIEW_TYPE
        }
    }

    override fun isGroup(viewType: Int): Boolean {

        return viewType == VEHICLE_REGULAR_GROUP_VIEW_TYPE ||
                viewType == VEHICLE_SUMMARY_INFO_GROUP_VIEW_TYPE ||
                viewType == VEHICLE_PERSONAL_DATA_GROUP_VIEW_TYPE ||
                viewType == VEHICLE_MAP_VIEW_TYPE
    }

    override fun isChild(viewType: Int): Boolean {
        return viewType == VEHICLE_AD_VIEW_TYPE ||
                viewType == VEHICLE_DETAILS_VIEW_TYPE ||
                viewType == VEHICLE_PRICE_OPTION_VIEW_TYPE ||
                viewType == VEHICLE_OVERALL_RATING_VIEW_TYPE ||
                viewType == VEHICLE_RATING_VIEW_TYPE ||
                viewType == VEHICLE_ENGINE_RATING_VIEW_TYPE ||
                viewType == VEHICLE_USER_RATING_VIEW_TYPE ||
                viewType == VEHICLE_TIME_LINE_VIEW_TYPE ||
                viewType == VEHICLE_PERSONAL_DATA_CHILD_VIEW_TYPE
    }
}