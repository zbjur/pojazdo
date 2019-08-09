package com.pojazdo.architecture.ui.summary.list.holder.groupholder

import android.view.View
import android.widget.TextView
import com.pojazdo.architecture.R
import com.pojazdo.architecture.ui.summary.model.modelsection.VehicleMapSection
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder

class VehicleMapHolder(itemView: View) : GroupViewHolder(itemView) {

    private var keyTitle: TextView? = null
    private var valueTitle: TextView? = null

    init {
        keyTitle = itemView.findViewById(R.id.event_date_text)
        valueTitle = itemView.findViewById(R.id.event_value_text)
    }

    fun setLocation(vehicleMapSection: VehicleMapSection) {

    }
}