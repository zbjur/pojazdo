package com.pojazdo.architecture.ui.summary.list.holder

import android.view.View
import android.widget.TextView
import com.pojazdo.architecture.R
import com.pojazdo.architecture.ui.summary.model.VehicleLocationSection
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder

class VehicleLocationHolder(itemView: View) : ChildViewHolder(itemView) {

    private var keyTitle: TextView? = null
    private var valueTitle: TextView? = null

    init {
        keyTitle = itemView.findViewById(R.id.event_date_text)
        valueTitle = itemView.findViewById(R.id.event_value_text)
    }

    fun setLocation(vehicleLocation: VehicleLocationSection) {
        keyTitle?.text = vehicleLocation.value
    }
}