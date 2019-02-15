package com.mirek.architecture.ui.application

import android.content.Context
import android.support.v4.app.Fragment

interface Navigator {
    fun openScanner(fragment: Fragment)
    fun openVehicleSummaryActivity(context: Context?, registerNumber: String, registrationDate: String, vin: String)
}