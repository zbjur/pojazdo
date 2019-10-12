package com.pojazdo.mobile.ui.vehiclesummary.list.vehiclesummary

import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import androidx.navigation.findNavController
import com.github.vivchar.rendererrecyclerviewadapter.ViewHolder
import com.pojazdo.mobile.R

class VehicleSummaryInfoHolder(itemView: View?) : ViewHolder(itemView), View.OnClickListener {

    var vehicleBrandHeader: TextView? = null
    var vehicleModelHeader: TextView? = null
    var vehicleProductionYearHeader: TextView? = null
    var vehicleAmountKmHeader: TextView? = null
    var vehicleEngineSizeHeader: TextView? = null
    var vehicleFuelTypeHeader: TextView? = null
    var vehicleRatingNumber: TextView? = null
    var vehicleRating: RatingBar? = null
    var vehicleCommentsNumber: TextView? = null
    var vehicleVinHeader: TextView? = null
    var vehicleVin: TextView? = null
    var vehicleInsuranceHeader: TextView? = null
    var vehicleInsurance: TextView? = null
    var vehicleTechnicalExaminationHeader: TextView? = null
    var vehicleTechnicalExamination: TextView? = null
    var vehicleLastMeterStateHeader: TextView? = null
    var vehicleLastMeterState: TextView? = null
    var vehicleCommentsText: TextView? = null

    init {
        vehicleBrandHeader = itemView?.findViewById(R.id.vehicle_brand)
        vehicleModelHeader = itemView?.findViewById(R.id.vehicle_model)
        vehicleProductionYearHeader = itemView?.findViewById(R.id.vehicle_production_year)
        vehicleAmountKmHeader = itemView?.findViewById(R.id.vehicle_last_meter_state)
        vehicleEngineSizeHeader = itemView?.findViewById(R.id.vehicle_engine_capacity_header)
        vehicleFuelTypeHeader = itemView?.findViewById(R.id.vehicle_fuel_type)
        vehicleRatingNumber = itemView?.findViewById(R.id.vehicle_rating_number)
        vehicleRating = itemView?.findViewById(R.id.vehicle_rating_bar)
        vehicleCommentsNumber = itemView?.findViewById(R.id.vehicle_comments_number)

        vehicleVin = itemView?.findViewById(R.id.vehicle_vin)
        vehicleInsuranceHeader = itemView?.findViewById(R.id.vehicle_insurance_header)
        vehicleInsurance = itemView?.findViewById(R.id.vehicle_insurance)
        vehicleTechnicalExaminationHeader = itemView?.findViewById(R.id.technical_examination_header)
        vehicleTechnicalExamination = itemView?.findViewById(R.id.technical_examination)
        vehicleLastMeterStateHeader = itemView?.findViewById(R.id.vehicle_last_meter_state)
        vehicleLastMeterState = itemView?.findViewById(R.id.vehicle_last_meter_state)
        vehicleCommentsText = itemView?.findViewById(R.id.vehicle_comments_text)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.textView49 -> v.findNavController().navigate(R.id.action_vehicleSummaryFragment_to_vehicleDetailsFragment)
            else -> v?.findNavController()?.navigate(R.id.action_vehicleSummaryFragment_to_vehicleDetailsFragment)
        }
    }

    fun setVehicleSummaryInfo(vehicleSummaryInfoModel: VehicleSummaryInfoModel) {
        vehicleBrandHeader?.text = vehicleSummaryInfoModel.brand
        vehicleModelHeader?.text = vehicleSummaryInfoModel.model
        vehicleProductionYearHeader?.text = vehicleSummaryInfoModel.yearOfProduction.toString()
        vehicleAmountKmHeader?.text = vehicleSummaryInfoModel.lastMeterState
        vehicleEngineSizeHeader?.text = vehicleSummaryInfoModel.engineCapacity
        vehicleFuelTypeHeader?.text = vehicleSummaryInfoModel.fuel
        vehicleVin?.text = vehicleSummaryInfoModel.vin
        vehicleInsurance?.text = vehicleSummaryInfoModel.insurance
        vehicleTechnicalExamination?.text = vehicleSummaryInfoModel.technicalExamination
        vehicleLastMeterState?.text = vehicleSummaryInfoModel.lastMeterState
        vehicleVinHeader?.text = vehicleSummaryInfoModel.vin
    }
}