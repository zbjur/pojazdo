package com.pojazdo.mobile.ui.vehiclesummary.rating.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pojazdo.api.network.vehicleinformation.model.UserRatings
import com.pojazdo.mobile.R

class UserCommentsAdapter(private val userRatings: List<UserRatings>?) : RecyclerView.Adapter<UserCommentsAdapter.UserCommentsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserCommentsViewHolder {
        return UserCommentsViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.user_comment_item, parent, false))
    }

    override fun onBindViewHolder(holderUserComments: UserCommentsViewHolder, position: Int) {
        val userRating = userRatings?.get(position)
        holderUserComments.apply {
            userName?.text = userRating?.user
            vehicleModel?.text = userRating?.model
            comments?.text = userRating?.comment
        }
    }

    override fun getItemCount() = userRatings!!.size

    class UserCommentsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var userName: TextView? = null
        var vehicleModel: TextView? = null
        var comments: TextView? = null

        init {
            userName = itemView.findViewById(R.id.commenting_user_name)
            vehicleModel = itemView.findViewById(R.id.user_vehicle_model)
            comments = itemView.findViewById(R.id.user_comments)
        }
    }
}