package com.pojazdo.mobile.ui.vehiclesummary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.pojazdo.mobile.R
import com.pojazdo.mobile.ui.vehiclesummary.viewmodel.VehicleDetailsViewModel

class VehicleDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = VehicleDetailsFragment()
    }

    private lateinit var viewModel: VehicleDetailsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.vehicle_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(VehicleDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
