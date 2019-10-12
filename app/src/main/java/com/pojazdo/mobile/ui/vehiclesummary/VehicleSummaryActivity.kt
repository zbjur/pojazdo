package com.pojazdo.mobile.ui.vehiclesummary

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.pojazdo.mobile.R
import com.pojazdo.mobile.extension.viewModelProvider
import com.pojazdo.mobile.ui.Event
import com.pojazdo.mobile.ui.base.Command
import com.pojazdo.mobile.ui.platform.BaseActivity
import com.pojazdo.mobile.ui.platform.util.FragmentUtils
import com.pojazdo.mobile.ui.vehiclesummary.editseller.EditSellerDataFragment
import javax.inject.Inject

class VehicleSummaryActivity : BaseActivity() {

    companion object {
        const val REGISTER_NUMBER = "register_number"
        const val REGISTRATION_DATE = "registration_date"
        const val VIN = "vin"

        private lateinit var navController: NavController

        fun createIntent(context: Context, registerNumber: String, registrationDate: String, vin: String) = Intent(context, VehicleSummaryActivity::class.java)
                .putExtra(REGISTER_NUMBER, registerNumber)
                .putExtra(REGISTRATION_DATE, registrationDate)
                .putExtra(VIN, vin)
    }

    @Inject
    lateinit var vehicleInformationViewModel: VehicleInformationViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_summary)
        appComponent.inject(this)
        vehicleInformationViewModel = viewModelProvider(viewModelFactory)
        initObservers()
        navController = findNavController(R.id.vehicle_summary_nav_fragment)
    }

    override fun layoutId() = R.layout.activity_vehicle_summary

    private fun initObservers() {
        vehicleInformationViewModel.viewState.observe(this, Observer {
            renderViewState(it)
        })
    }

    private fun renderViewState(it: Event<Command>?) {
        it?.hasBeenHandled
        it?.getContentIfNotHandled()?.let {
            when (it) {
                is Command.NavigateToEditPersonalSellerDataScreenEvent -> showEditSellerPersonalDataView()
                is Command.NavigateToVehicleSummaryInfoScreenEvent -> handleBackPressedInCurrentFragment()
            }
        }
    }

    private fun showEditSellerPersonalDataView() {
        FragmentUtils.replaceFragment(this, EditSellerDataFragment.newInstance(), R.id.fragment_container, true)
    }

    override fun onBackPressed() {
        handleBackPressedInCurrentFragment()
    }

    private fun handleBackPressedInCurrentFragment() {
        super.onBackPressed()
/*        val baseFragment = FragmentUtils.getFragmentById(this, R.sellerId.fragment_container)
        if (baseFragment != null && baseFragment is VehicleSummaryFragment) {
            finish()
        } else {
            super.onBackPressed()
        }*/
    }
}