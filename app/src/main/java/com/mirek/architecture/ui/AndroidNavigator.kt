package com.mirek.architecture.ui

import android.content.Context
import android.support.v4.app.Fragment
import com.google.zxing.integration.android.IntentIntegrator
import com.mirek.architecture.ui.application.Navigator
import com.mirek.architecture.ui.summary.VehicleSummaryActivity
import javax.inject.Inject

class AndroidNavigator @Inject constructor() : Navigator {

    override fun openScanner(fragment: Fragment) {
   /*     val integrator = IntentIntegrator.forSupportFragment(fragment)
        integrator.apply {
            setDesiredBarcodeFormats(IntentIntegrator)
            setBeepEnabled(true)
            setPrompt("Scan a barcode")
            integrator.setCameraId(0);  // Use a specific camera of the device
            setOrientationLocked(false)
            setBarcodeImageEnabled(true)
            setPrompt("Jakis tam mój wesoły tekst")
            initiateScan()
        }*/
    }

    override fun openVehicleSummaryActivity(context: Context?, registerNumber: String, registrationDate: String, vin: String) {
        VehicleSummaryActivity.createIntent(context!!, registerNumber, registrationDate, vin).let { context?.startActivity(it) }
    }
}