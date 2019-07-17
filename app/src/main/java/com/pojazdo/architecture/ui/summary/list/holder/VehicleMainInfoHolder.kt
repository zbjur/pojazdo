package com.pojazdo.architecture.ui.summary.list.holder

import android.view.View
import android.widget.RatingBar
import android.widget.TextView
import com.pojazdo.architecture.R
import com.pojazdo.architecture.ui.summary.model.VehicleMainInfoSubsections
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder

class VehicleMainInfoHolder(itemView: View?) : ChildViewHolder(itemView) {

    var vehicleBrandHeader: TextView? = null
    var vehicleModelHeader: TextView? = null
    var vehicleProductionYearHeader: TextView? = null
    var vehicleAmountKmHeader: TextView? = null
    var vehicleEngineSizeHeader: TextView? = null
    var vehicleEngineCapacityHeader: TextView? = null
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
        vehicleEngineCapacityHeader = itemView?.findViewById(R.id.textView)
        vehicleFuelTypeHeader = itemView?.findViewById(R.id.vehicle_fuel_type)
        vehicleRatingNumber = itemView?.findViewById(R.id.vehicle_rating_number)
        vehicleRating = itemView?.findViewById(R.id.vehicle_rating)
        vehicleCommentsNumber = itemView?.findViewById(R.id.vehicle_comments_number)
        vehicleVinHeader = itemView?.findViewById(R.id.vehicle_vin_header)
        vehicleVin = itemView?.findViewById(R.id.vehicle_vin)
        vehicleInsuranceHeader = itemView?.findViewById(R.id.vehicle_insurance_header)
        vehicleInsurance = itemView?.findViewById(R.id.vehicle_insurance)
        vehicleTechnicalExaminationHeader = itemView?.findViewById(R.id.technical_examination_header)
        vehicleTechnicalExamination = itemView?.findViewById(R.id.technical_examination)
        vehicleLastMeterStateHeader = itemView?.findViewById(R.id.vehicle_last_meter_state)
        vehicleLastMeterState = itemView?.findViewById(R.id.vehicle_last_meter_state)
        vehicleCommentsText = itemView?.findViewById(R.id.vehicle_comments_text)
    }

    fun setVehicleMainInfo(vehicleMainInfoSubsections: VehicleMainInfoSubsections) {
        vehicleBrandHeader?.text = vehicleMainInfoSubsections.brand
        vehicleBrandHeader?.text = vehicleMainInfoSubsections.model
    }
}