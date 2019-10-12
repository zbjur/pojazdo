package com.pojazdo.mobile.ui.vehiclesummary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pojazdo.mobile.R
import com.pojazdo.mobile.ui.platform.BaseFragment
import com.pojazdo.mobile.ui.vehiclesummary.VehicleInformationViewModel
import com.pojazdo.mobile.ui.vehiclesummary.rating.list.UserCommentsAdapter
import com.pojazdo.mobile.ui.vehiclesummary.viewmodel.UserCommentsViewModel
import kotlinx.android.synthetic.main.user_comments_fragment.*
import javax.inject.Inject

class UserCommentsFragment : BaseFragment() {
    companion object {

        fun newInstance() = UserCommentsFragment()
    }

    private lateinit var viewModel: UserCommentsViewModel

    @Inject
    lateinit var vehicleInformationViewModel: VehicleInformationViewModel

    lateinit var commentsAdapter: UserCommentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        activity?.let {
            vehicleInformationViewModel = ViewModelProviders.of(it).get(VehicleInformationViewModel::class.java)
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.user_comments_fragment, container, false)
        val userRating = vehicleInformationViewModel.vehicleRating?.userRatings
        commentsAdapter = UserCommentsAdapter(userRating)
        val recyclerView = view.findViewById(R.id.user_comments_recycler_view) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = commentsAdapter
        val topToolBar = view.findViewById(R.id.toolbar) as Toolbar
        topToolBar.title = "KOmentarze"

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UserCommentsViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun layoutId() = R.layout.activity_vehicle_summary
}

