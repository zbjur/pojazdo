package com.pojazdo.architecture.ui.summary.list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.pojazdo.architecture.R
import com.pojazdo.architecture.ui.summary.model.VehicleAd
import com.pojazdo.architecture.ui.summary.model.VehicleAdSection
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
                .load("https://apollo-ireland.akamaized.net/v1/files/eyJmbiI6Im9pMG5pMGh1NTNhcTItT1RPTU9UT1BMIiwidyI6W3siZm4iOiJ3ZzRnbnFwNnkxZi1PVE9NT1RPUEwiLCJzIjoiMTYiLCJwIjoiMTAsLTEwIiwiYSI6IjAifV19.Lpt6WzA6B6v0MBXctk04NMGdX2-MMnPCvUwBOniF7m0/image;s=1080x720;cars_;/927269814_;slot=3;filename=eyJmbiI6Im9pMG5pMGh1NTNhcTItT1RPTU9UT1BMIiwidyI6W3siZm4iOiJ3ZzRnbnFwNnkxZi1PVE9NT1RPUEwiLCJzIjoiMTYiLCJwIjoiMTAsLTEwIiwiYSI6IjAifV19.Lpt6WzA6B6v0MBXctk04NMGdX2-MMnPCvUwBOniF7m0_rev001.jpg")
                .centerCrop()
                .into(holder.imgView)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgView : ImageView = itemView.ad_background
        val brandTextView: TextView = itemView.vehicle_ad_brand
        val modelTextView: TextView = itemView.vehicle_ad_model
        val engineTextView: TextView = itemView.vehicle_ad_engine
        val priceTextView: TextView = itemView.vehicle_ad_price
    }
}