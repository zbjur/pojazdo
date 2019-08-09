package com.pojazdo.architecture.ui.application

import android.content.Context
import androidx.fragment.app.Fragment

interface Navigator {
    fun openScanner(fragment: androidx.fragment.app.Fragment)
    fun openVehicleSummaryActivity(context: Context?, registerNumber: String, registrationDate: String, vin: String)
}