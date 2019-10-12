package com.pojazdo.mobile.ui.vehiclesummary.list.sellerdetails

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import com.github.vivchar.rendererrecyclerviewadapter.ViewHolder
import com.pojazdo.mobile.R

class   VehiclePersonalDataGroupHolder(itemView: View) : ViewHolder(itemView), View.OnClickListener {


    open interface EditSellerListener {
        fun onClickEditSellerListener()
    }

    private var sellerStreetName: TextView? = null
    private var sellerCityName: TextView? = null
    private val editUserDataButton: ImageView?

    private var editSellerListener: EditSellerListener? = null


    init {
        sellerStreetName = itemView.findViewById(R.id.sellerStreetText)
        sellerCityName = itemView.findViewById(R.id.sellerCityText)
        editUserDataButton = itemView.findViewById(R.id.edit_user_data_button)
      //  editUserDataButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.edit_user_data_button -> v.findNavController().navigate(R.id.action_vehicleSummaryFragment_to_editSellerDataFragment)

        }
    }

    fun setOnEditSellerListener(editSellerListener: EditSellerListener?) {
        this.editSellerListener = editSellerListener
    }

    fun setPersonalData(vehiclePersonalDataSection: VehiclePersonalDataSection) {
        sellerStreetName?.text = vehiclePersonalDataSection.city
        sellerCityName?.text = vehiclePersonalDataSection.street
    }
}