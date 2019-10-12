package com.pojazdo.mobile.ui.vehiclesummary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.pojazdo.mobile.R
import com.pojazdo.mobile.ui.vehiclesummary.viewmodel.UserRatingViewModel

class UserRatingFragment : Fragment() {

    companion object {
        fun newInstance() = UserRatingFragment()
    }

    private lateinit var viewModel: UserRatingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.user_rating_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UserRatingViewModel::class.java)
        // TODO: Use the ViewModel
    }
}
