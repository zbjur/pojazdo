package com.pojazdo.mobile.ui.vehiclesummary.list.map

import android.view.View
import android.widget.Button
import androidx.navigation.findNavController
import com.github.vivchar.rendererrecyclerviewadapter.ViewHolder
import com.pojazdo.mobile.R

class VehicleMapHolder(itemView: View) : ViewHolder(itemView), View.OnClickListener {

    private val navMapButton: Button? = itemView.findViewById(R.id.navigate_to_map_button)

    init {
        this.navMapButton?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.navigate_to_map_button -> v.findNavController().navigate(R.id.action_vehicleSummaryFragment_to_userCommentsFragment)
        }
    }

    fun setLocation(vehicleMapSection: VehicleMapSection) {

    }
}