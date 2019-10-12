package com.pojazdo.mobile.ui

import android.content.Context
import com.pojazdo.mobile.ui.application.Navigator
import com.pojazdo.mobile.ui.vehiclesummary.VehicleSummaryActivity
import javax.inject.Inject

class AndroidNavigator @Inject constructor() : Navigator {

    override fun openScanner(fragment: androidx.fragment.app.Fragment) {
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