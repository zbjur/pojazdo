package com.pojazdo.mobile.ui.vehiclesummary.list.comments

import android.view.View
import android.widget.TextView
import com.github.vivchar.rendererrecyclerviewadapter.ViewHolder
import com.pojazdo.mobile.R
import com.pojazdo.mobile.ui.vehiclesummary.model.modelsubsection.VehicleUserRatingSection

class UserCommentsHolder(itemView: View?) : ViewHolder(itemView) {

    var rating: TextView? = null
    var userName: TextView? = null
    var vehicleModel: TextView? = null
    var comments: TextView? = null

    init {
        rating= itemView?.findViewById(R.id.average_vehicle_rating)
        userName = itemView?.findViewById(R.id.commenting_user_name)
        vehicleModel = itemView?.findViewById(R.id.user_vehicle_model)
        comments = itemView?.findViewById(R.id.user_comments)
    }

    fun setUserComments(userRating: VehicleUserRatingSection) {
        rating?.text = userRating.rating
        userName?.text = userRating.user
        vehicleModel?.text = userRating.model
        comments?.text = userRating.comment
    }
}