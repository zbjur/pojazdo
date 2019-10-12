package com.pojazdo.mobile.ui.vehiclesummary.list.saleoffers

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.github.vivchar.rendererrecyclerviewadapter.ViewHolder
import com.pojazdo.mobile.R
import com.pojazdo.mobile.ui.vehiclesummary.model.modelsubsection.VehicleOffersSection

class VehicleSaleOffersHolder(itemView: View?, val ctx: Context) : ViewHolder(itemView) {

    var valueBrand: TextView? = null
    var valueModel: TextView? = null
    var valueEngine: TextView? = null
    var valuePrice: TextView? = null
    lateinit var vehicleImage: ImageView

    init {
        /*valueBrand = itemView?.findViewById(R.id.vehicle_ad_brand)*/
        valueModel = itemView?.findViewById(R.id.vehicle_ad_model)
        valueEngine = itemView?.findViewById(R.id.vehicle_ad_engine)
        valuePrice = itemView?.findViewById(R.id.vehicle_ad_price)
        vehicleImage = itemView!!.findViewById(R.id.ad_background)
    }

    fun setVehicleSaleOffer(vehicleSaleOffersSectionSection: VehicleOffersSection) {
       // valueBrand?.text = vehicleSaleOffersSectionSection.brand
        valueModel?.text = vehicleSaleOffersSectionSection.model
        valueEngine?.text = vehicleSaleOffersSectionSection.engine
        valuePrice?.text = vehicleSaleOffersSectionSection.price


 /*       Glide.with(ctx)
                .load("https://www.otomoto.pl/oferta/porsche-911-carrera-targa-3-6-boxer-320km-salon-pl-ID6BRkuy.html#2e83b13067")
                .centerCrop()
                .into(vehicleImage)*/

    }
}