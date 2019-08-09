package com.pojazdo.architecture.ui.summary.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pojazdo.architecture.R
import com.pojazdo.architecture.ui.summary.model.modelsubsection.VehicleAd
import kotlinx.android.synthetic.main.vehicle_ad_item.view.*

class VehicleAdsAdapter(private val cxt: Context, private val vehicleAds: List<VehicleAd>) : RecyclerView.Adapter<VehicleAdsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.vehicle_ad_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return vehicleAds.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val vehicleAd = vehicleAds[position]
        holder.brandTextView.text = vehicleAd.brand
        holder.modelTextView.text = vehicleAd.model
        holder.engineTextView.text = vehicleAd.engine
        holder.priceTextView.text = vehicleAd.price

        Glide.with(cxt)
                .load(vehicleAd.imageUrl)
                .centerCrop()
                .into(holder.imgView)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgView: ImageView = itemView.ad_background
        val brandTextView: TextView = itemView.vehicle_ad_brand
        val modelTextView: TextView = itemView.vehicle_ad_model
        val engineTextView: TextView = itemView.vehicle_ad_engine
        val priceTextView: TextView = itemView.vehicle_ad_price
    }
}