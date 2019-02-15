package com.mirek.architecture.ui.summary

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.mirek.architecture.R
import com.mirek.architecture.extension.viewModelProvider
import com.mirek.architecture.ui.platform.BaseActivity
import javax.inject.Inject

class VehicleSummaryActivity : BaseActivity() {

    companion object {
        const val REGISTER_NUMBER = "register_number"
        const val REGISTRATION_DATE = "registration_date"
        const val VIN = "vin"

        fun createIntent(context: Context, registerNumber: String, registrationDate: String, vin: String) = Intent(context, VehicleSummaryActivity::class.java)
                .putExtra(REGISTER_NUMBER, registerNumber)
                .putExtra(REGISTRATION_DATE, registrationDate)
                .putExtra(VIN, vin)
    }

    @Inject
    lateinit var vehicleSumaryViewModel: VehicleSumaryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_summary)
        appComponent.inject(this)
        vehicleSumaryViewModel = viewModelProvider(viewModelFactory)
        vehicleSumaryViewModel = ViewModelProviders.of(this).get(VehicleSumaryViewModel::class.java)

        readVehicleData(intent, savedInstanceState)
    }

    override fun layoutId() = R.layout.activity_vehicle_summary

    private fun readVehicleData(intent: Intent?, savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            checkVehicle(intent)
        }
    }

    private fun checkVehicle(intent: Intent?) {
        intent?.getStringExtra(REGISTER_NUMBER)
        intent?.getStringExtra(VIN)
        intent?.getStringExtra(REGISTRATION_DATE)
    }

}
