package com.pojazdo.architecture.ui.summary

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pojazdo.architecture.R
import com.pojazdo.architecture.extension.viewModelProvider
import com.pojazdo.architecture.ui.base.Command
import com.pojazdo.architecture.ui.platform.BaseActivity
import com.pojazdo.architecture.ui.summary.list.VehicleSummaryInformationAdapter
import com.pojazdo.architecture.ui.summary.model.modelsection.VehicleSections
import kotlinx.android.synthetic.main.activity_vehicle_summary.*
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

    lateinit var vehicleSummaryInformationAdapter: VehicleSummaryInformationAdapter

    @Inject
    lateinit var vehicleInformationViewModel: VehicleInformationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_summary)
        appComponent.inject(this)
        vehicleInformationViewModel = viewModelProvider(viewModelFactory)
        vehicleInformationViewModel = ViewModelProviders.of(this).get(VehicleInformationViewModel::class.java)
        initObservers()
        readVehicleData(intent, savedInstanceState)

        val layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        recycler_view.layoutManager = layoutManager
    }

    override fun layoutId() = R.layout.activity_vehicle_summary

    private fun readVehicleData(intent: Intent?, savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            checkVehicle(intent)
            vehicleInformationViewModel.checkVehicleInformation("TTSTSYSYSYSY", "SCI 555", "2011.09.09")
        }
    }

    private fun initObservers() {
        vehicleInformationViewModel.viewState.observe(this, Observer {
            renderViewState(it)
        })
    }

    private fun renderViewState(it: com.pojazdo.architecture.ui.Event<Command>?) {
        it?.getContentIfNotHandled()?.let {
            when (it) {
                is Command.ShowVehicleInfo -> showVehicleInformation(it.vehicleInformationList)
                is Command.ShowProgress -> showProgressBar()
                is Command.HideProgress -> hideProgressBar()
                is Command.Error -> showErrorView(it.errorMessage)
            }
        }
    }

    private fun showVehicleInformation(vehicleInformationList: MutableList<VehicleSections>?) {
        vehicleSummaryInformationAdapter = VehicleSummaryInformationAdapter(this, vehicleInformationList)
        recycler_view.adapter = vehicleSummaryInformationAdapter
    }

    private fun hideProgressBar() {}

    private fun showProgressBar() {}

    private fun showErrorView(errorMessage: String?) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }


    private fun checkVehicle(intent: Intent?) {
        intent?.getStringExtra(REGISTER_NUMBER)
        intent?.getStringExtra(VIN)
        intent?.getStringExtra(REGISTRATION_DATE)
    }
}
