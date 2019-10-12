package com.pojazdo.mobile.ui.form

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.google.zxing.integration.android.IntentIntegrator
import com.pojazdo.mobile.R
import com.pojazdo.mobile.extension.viewModelProvider
import com.pojazdo.mobile.ui.Event
import com.pojazdo.mobile.ui.aztecscanner.VehicleScannerViewModel
import com.pojazdo.mobile.ui.base.Command
import com.pojazdo.mobile.ui.platform.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*

import javax.inject.Inject


class FormFragment : BaseFragment() {

    companion object {
        fun newInstance() = FormFragment()
    }

    @Inject
    lateinit var vehicleScannerViewModel: VehicleScannerViewModel

    private var listener: OnFragmentInteractionListener? = null

    override fun layoutId() = R.layout.fragment_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        vehicleScannerViewModel = viewModelProvider(viewModelFactory)
        vehicleScannerViewModel = ViewModelProviders.of(this).get(VehicleScannerViewModel::class.java)
        vehicleScannerViewModel.setCarInputDataField()


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initListeners()
        initObservers()
    }

    private fun initListeners() {
        setScanButtonListener()
        setCheckVehicleButtonListener()
    }

    private fun setCheckVehicleButtonListener() {
        check_vehicle_button.setOnClickListener {
            vehicleScannerViewModel.checkVehicle(registerNumber.text.toString(), vinNumber.text.toString(), registerDate.text.toString())
        }
    }

    private fun setScanButtonListener() {

        scan_qr_code_button.setOnClickListener {
            //  vehicleScannerViewModel.onScanButtonClick()
            /* vehicleScannerViewModel.decodeAztecCode("", "", "")*/
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Toast.makeText(context, "onActivityResult", Toast.LENGTH_SHORT).show()
        IntentIntegrator.parseActivityResult(requestCode, resultCode, data).apply {
            Toast.makeText(context, "onActivityResult " + toString(), Toast.LENGTH_SHORT).show()
            System.out.println("scan result :  ${toString()}")
            //vehicleScannerViewModel.decodeAztecCode("", "", "")
        }
    }

    private fun initObservers() {
        vehicleScannerViewModel.viewState.observe(this, Observer {
            renderViewState(it)
        })
    }

    private fun renderViewState(it: Event<Command>?) {
        it?.getContentIfNotHandled()?.let {
            when (it) {
                is Command.NavigateToScannerView -> showScanner()
                is Command.ShowProgress -> showProgressBar()
                is Command.HideProgress -> hideProgressBar()
                is Command.NavigateToVehicleDecodedInfo -> initDecodedVehicleInfoView(it)
                is Command.NavigateToVehicleResultView -> showVehicleResultView(it.registrationNumber, it.vin, it.firstRegistrationDate)
                is Command.Error -> showErrorView(it.errorMessage)
            }
        }
    }

    private fun showErrorView(errorMessage: String?) {
        Toast.makeText(context, errorMessage, LENGTH_LONG).show()
    }

    private fun showVehicleResultView(registerNumber: String, vin: String, registrationDate: String) {
        navigator.openVehicleSummaryActivity(context, registerNumber, vin, registrationDate)
    }

    private fun hideProgressBar() {}

    private fun showProgressBar() {}

    private fun initDecodedVehicleInfoView(it: Command.NavigateToVehicleDecodedInfo) {
        registerNumber.setText(it?.registrationNumber)
        registerDate.setText(it?.firstRegistrationDate)
        vinNumber.setText(it?.vin)
    }

    fun showScanner() {
        navigator.openScanner(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            //throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }
}
