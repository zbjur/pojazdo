package com.pojazdo.mobile.ui.vehiclesummary.rating.view

interface PojazdoProgressViewContract {

    interface View {
        fun setRatingPointsText(ratingText: String)
        fun setRatingPointsProgressView(ratingText: Float)
    }
}