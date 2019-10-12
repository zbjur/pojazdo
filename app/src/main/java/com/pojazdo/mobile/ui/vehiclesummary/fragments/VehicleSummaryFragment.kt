package com.pojazdo.mobile.ui.vehiclesummary.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter
import com.github.vivchar.rendererrecyclerviewadapter.ViewModel
import com.pojazdo.mobile.R
import com.pojazdo.mobile.ui.Event
import com.pojazdo.mobile.ui.base.Command
import com.pojazdo.mobile.ui.platform.BaseFragment
import com.pojazdo.mobile.ui.vehiclesummary.VehicleInformationViewModel
import com.pojazdo.mobile.ui.vehiclesummary.VehicleSummaryActivity
import com.pojazdo.mobile.ui.vehiclesummary.list.ViewRendererFactory
import com.pojazdo.mobile.ui.vehiclesummary.list.sellerdetails.VehiclePersonalDataGroupHolder
import javax.inject.Inject

class VehicleSummaryFragment : BaseFragment(), VehiclePersonalDataGroupHolder.EditSellerListener {

    companion object {
        const val REGISTER_NUMBER = "register_number"
        const val REGISTRATION_DATE = "registration_date"
        const val VIN = "vin"

        fun newInstance() = VehicleSummaryFragment()
        fun createIntent(context: Context, registerNumber: String, registrationDate: String, vin: String) = Intent(context, VehicleSummaryActivity::class.java)
                .putExtra(REGISTER_NUMBER, registerNumber)
                .putExtra(REGISTRATION_DATE, registrationDate)
                .putExtra(VIN, vin)
    }

    lateinit var recycleView: RecyclerView

    lateinit var mRecyclerViewAdapter: RendererRecyclerViewAdapter

    @Inject
    lateinit var vehicleInformationViewModel: VehicleInformationViewModel

    @Inject
    lateinit var viewRendererFactory: ViewRendererFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        activity?.let {
            vehicleInformationViewModel = ViewModelProviders.of(it).get(VehicleInformationViewModel::class.java)
        }
        initObservers()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.vehicle_summary_fragment, container, false)
        initializeView(view)
        readVehicleData()
        return view
    }

    private fun initializeView(view: View) {
        recycleView = view.findViewById(R.id.recycler_view) as RecyclerView
        recycleView.layoutManager = LinearLayoutManager(context)
    }

    override fun onClickEditSellerListener() {
        vehicleInformationViewModel.showEditPersonalSellerDataView(null)
    }

    override fun layoutId() = R.layout.activity_vehicle_summary

    private fun readVehicleData() {
        //checkVehicle(intent)
        vehicleInformationViewModel.checkVehicleInformation("TTSTSYSYSYSY", "SCI 555", "2011.09.09")
    }

    private fun initObservers() {
        vehicleInformationViewModel.viewState.observe(this, Observer {
            renderViewState(it)
        })

        vehicleInformationViewModel.vehicleInformation?.observe(this, Observer {
            populateAdapter(it)
        })
    }

    private fun renderViewState(it: Event<Command>?) {
        it?.peekContent()?.let {
            when (it) {
                is Command.ShowProgress -> showProgressBar()
                is Command.HideProgress -> hideProgressBar()
                is Command.Error -> showErrorView(it.errorMessage)
            }
        }
    }

    private fun populateAdapter(viewModelList: MutableList<ViewModel>) {
        mRecyclerViewAdapter = RendererRecyclerViewAdapter()
        viewRendererFactory.bindViewRenderer(mRecyclerViewAdapter)
        mRecyclerViewAdapter!!.setItems(viewModelList)
        recycleView.adapter = mRecyclerViewAdapter
    }

    private fun hideProgressBar() {}

    private fun showProgressBar() {}

    private fun showErrorView(errorMessage: String?) {
    }

    private fun checkVehicle(intent: Intent?) {
        intent?.getStringExtra(REGISTER_NUMBER)
        intent?.getStringExtra(VIN)
        intent?.getStringExtra(REGISTRATION_DATE)
    }
}