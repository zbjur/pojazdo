package com.pojazdo.mobile.ui.application

import android.content.Context

interface Navigator {
    fun openScanner(fragment: androidx.fragment.app.Fragment)
    fun openVehicleSummaryActivity(context: Context?, registerNumber: String, registrationDate: String, vin: String)
}