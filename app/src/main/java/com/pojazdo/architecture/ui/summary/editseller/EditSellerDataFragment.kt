package com.pojazdo.architecture.ui.summary.editseller

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.pojazdo.api.database.vehicleadditionalinformation.model.Seller

import com.pojazdo.architecture.R
import com.pojazdo.architecture.ui.base.Command
import com.pojazdo.architecture.ui.platform.BaseFragment
import com.pojazdo.architecture.ui.summary.VehicleInformationViewModel
import kotlinx.android.synthetic.main.edit_seller_data_fragment.*

class EditSellerDataFragment : BaseFragment() {

    companion object {
        fun newInstance() = EditSellerDataFragment()
    }

    private lateinit var vehicleInformationViewModel:  VehicleInformationViewModel

    override fun layoutId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        return inflater.inflate(R.layout.edit_seller_data_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        activity?.let {
            /**
             *  create view model in activity scope
             */

            vehicleInformationViewModel =  ViewModelProviders.of(it).get(VehicleInformationViewModel::class.java)
        }

        initListeners()
        initObservers()
    }

    private fun initListeners() {
        setSaveSellerPersonalDataButtonListener()
    }

    private fun setSaveSellerPersonalDataButtonListener() {
        save_seller_data_button.setOnClickListener {
            vehicleInformationViewModel.updateSellePersonalData(Seller(1,"","","","","","",0.0,0.0))
        }
    }

    private fun initObservers() {
        vehicleInformationViewModel.viewState.observe(this, Observer {
            renderViewState(it)
        })
    }


    private fun renderViewState(it: com.pojazdo.architecture.ui.Event<Command>?) {

    }

}
