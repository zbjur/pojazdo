package com.pojazdo.architecture.ui.summary.list.holder.groupholder

import android.view.View
import android.widget.TextView
import com.pojazdo.architecture.R
import com.pojazdo.architecture.ui.summary.model.modelsection.VehiclePersonalDataSection
import com.pojazdo.architecture.ui.summary.model.modelsubsection.VehiclePersonalDataSubSection
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder

class VehiclePersonalDataGroupHolder(itemView: View) : GroupViewHolder(itemView) {

    private var keyTitle: TextView? = null
    private var valueTitle: TextView? = null

    init {
        keyTitle = itemView.findViewById(R.id.event_date_text)
        valueTitle = itemView.findViewById(R.id.event_value_text)
    }

    fun setPersonalData(vehiclePersonalDataSub: VehiclePersonalDataSection) {
        keyTitle?.text = vehiclePersonalDataSub.city
        valueTitle?.text = vehiclePersonalDataSub.street
    }
}