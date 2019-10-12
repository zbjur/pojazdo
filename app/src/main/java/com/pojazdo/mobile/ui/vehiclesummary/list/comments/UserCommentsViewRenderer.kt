package com.pojazdo.mobile.ui.vehiclesummary.list.rating

import android.view.ViewGroup

import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer
import com.pojazdo.mobile.R
import com.pojazdo.mobile.ui.vehiclesummary.list.comments.UserCommentsHolder
import com.pojazdo.mobile.ui.vehiclesummary.model.modelsubsection.VehicleUserRatingSection

class UserCommentsViewRenderer : ViewRenderer<VehicleUserRatingSection, UserCommentsHolder>(VehicleUserRatingSection::class.java) {

    override fun bindView(VehicleOverallRatingSection: VehicleUserRatingSection, vehicleModelHolder: UserCommentsHolder) {
        vehicleModelHolder.setUserComments(VehicleOverallRatingSection)
    }

    override fun createViewHolder(parent: ViewGroup?): UserCommentsHolder {
        return UserCommentsHolder(inflate(R.layout.user_comment_item, parent))
    }

    interface Listener {
        fun onCategoryClicked(model: UserComments)
    }
}