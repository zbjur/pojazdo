package com.pojazdo.architecture.ui.summary.list.holder.childerholder

import android.view.View
import android.widget.TextView
import com.pojazdo.architecture.R
import com.pojazdo.architecture.ui.summary.model.modelsubsection.VehicleUserRatingSubSection
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder

class VehicleUserRatingHolder(itemView: View?) : ChildViewHolder(itemView) {

    private var ratingPoints: TextView? = null
    private var ratingBrandModel: TextView? = null
    private var ratingModelType: TextView? = null
    private var ratingUser: TextView? = null
    private var ratingComment: TextView? = null

    init {
        ratingPoints = itemView?.findViewById(R.id.vehicle_rating_points)
        ratingBrandModel = itemView?.findViewById(R.id.vehicle_rating_brand_model)
        ratingModelType = itemView?.findViewById(R.id.vehicle_rating_model_type)
        ratingComment = itemView?.findViewById(R.id.rating_vehicle_comment)
    }

    fun setUserRating(rating: VehicleUserRatingSubSection) {
        ratingPoints?.text = rating.rating
        ratingBrandModel?.text = rating.type
        ratingModelType?.text = rating.model
        ratingComment?.text = rating.comment
    }
}