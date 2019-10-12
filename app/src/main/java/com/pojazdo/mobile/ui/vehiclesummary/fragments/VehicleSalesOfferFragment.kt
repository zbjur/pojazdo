package com.pojazdo.mobile.ui.vehiclesummary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.pojazdo.mobile.R
import com.pojazdo.mobile.ui.vehiclesummary.viewmodel.VehicleSaleOfferViewModel

class VehicleSalesOfferFragment : Fragment() {

    companion object {
        fun newInstance() = VehicleSalesOfferFragment()
    }

    private lateinit var viewModel: VehicleSaleOfferViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.vehicle_sale_offer_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(VehicleSaleOfferViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
