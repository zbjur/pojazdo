package com.pojazdo.architecture.ui.summary.list.holder.groupholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.pojazdo.architecture.R
import com.pojazdo.architecture.ui.summary.model.modelsection.VehiclePersonalDataSection
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder

class VehiclePersonalDataGroupHolder(itemView: View) : GroupViewHolder(itemView), View.OnClickListener {


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
        editUserDataButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.edit_user_data_button -> editSellerListener?.onClickEditSellerListener()
            else -> onGroupClick()
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