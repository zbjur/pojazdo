package com.pojazdo.mobile.ui.vehiclesummary.list.holder.childerholder

import android.view.View
import android.widget.TextView
import com.pojazdo.mobile.R
import com.pojazdo.mobile.ui.vehiclesummary.model.modelsubsection.VehiclePersonalDataSubSection
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