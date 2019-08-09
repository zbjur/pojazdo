package com.pojazdo.architecture.ui.summary.list.holder.childerholder

import android.view.View
import android.widget.TextView
import com.pojazdo.architecture.R
import com.pojazdo.architecture.ui.summary.model.modelsubsection.VehiclePersonalDataSubSection
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder

class VehiclePersonalDataChildHolder(itemView: View) : ChildViewHolder(itemView) {

    private var keyTitle: TextView? = null
    private var valueTitle: TextView? = null

    init {
        keyTitle = itemView.findViewById(R.id.event_date_text)
        valueTitle = itemView.findViewById(R.id.event_value_text)
    }

    fun setPersonalData(vehiclePersonalDataSub: VehiclePersonalDataSubSection) {
        keyTitle?.text = vehiclePersonalDataSub.email
        valueTitle?.text = vehiclePersonalDataSub.phone
    }
}