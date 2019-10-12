package com.pojazdo.mobile.ui.vehiclesummary.list.navigation

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.pojazdo.mobile.R
import javax.inject.Inject

class ContactDetailsFragmentStrategy @Inject constructor() : FragmentNavigationStrategy {
    override fun navigateToFragment(v: View) {
        v.findNavController().navigate(R.id.action_vehicleSummaryFragment_to_editSellerDataFragment)
    }
}