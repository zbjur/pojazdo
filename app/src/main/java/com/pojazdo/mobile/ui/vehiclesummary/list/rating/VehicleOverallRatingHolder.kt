package com.pojazdo.mobile.ui.vehiclesummary.list.rating

import android.view.View
import android.widget.TextView
import com.github.vivchar.rendererrecyclerviewadapter.ViewHolder
import com.pojazdo.mobile.R
import com.pojazdo.mobile.ui.vehiclesummary.rating.view.PojazdoProgressView

class VehicleOverallRatingHolder(itemView: View?) : ViewHolder(itemView) {

    private var averageVehicleRating: TextView? = null
    private var overallVehicleTitle: TextView? = null
    private var buyAgainPercentage: TextView? = null
    private var buyAgainTitle: TextView? = null

    init {
        /*   averageVehicleRating = itemView?.findViewById(R.id.average_vehicle_rating)
           overallVehicleTitle = itemView?.findViewById(R.id.overall_vehicle_title)
           buyAgainPercentage = itemView?.findViewById(R.id.buy_again_percentage)
           buyAgainTitle = itemView?.findViewById(R.id.buy_again_title)*/


        itemView?.findViewById<PojazdoProgressView>(R.id.ranting_engine)?.apply {
            setRatingPointsText("5.0")
            setRatingPointsProgressView(50.0f)
        }
        itemView?.findViewById<PojazdoProgressView>(R.id.ranting_gear_box)?.apply {
            setRatingPointsText("7.0")
            setRatingPointsProgressView(70.0f)
        }

        itemView?.findViewById<PojazdoProgressView>(R.id.ranting_chassis)?.apply {
            setRatingPointsText("3.0")
            setRatingPointsProgressView(30.0f)
        }
        itemView?.findViewById<PojazdoProgressView>(R.id.ranting_body)?.apply {
            setRatingPointsText("2.5")
            setRatingPointsProgressView(25.0f)
        }


    }

    fun setOverallRating(rating: VehicleOverallRatingSection) {
        /*  averageVehicleRating?.text = rating.overallRating
          overallVehicleTitle?.text = rating.overallTitle
          buyAgainPercentage?.text = rating.buyAgainPercentage
          buyAgainTitle?.text = rating.buyAgainTitle*/
    }
}