package com.pojazdo.architecture.ui.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pojazdo.architecture.R
import com.pojazdo.architecture.ui.form.FormFragment
import com.pojazdo.architecture.ui.history.HistoryListFragment
import kotlinx.android.synthetic.main.activity_start.*

class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var navigationViewMOdel: NavigationModelView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        replaceFragment(FormFragment.newInstance())
        navigation?.setOnNavigationItemSelectedListener(this)

        navigationViewMOdel = ViewModelProviders.of(this).get(NavigationModelView::class.java)
    }

    private fun subscribeToNavigationChanges(viewModel: NavigationModelView) {
        viewModel.launchDestination.observe(this, Observer {
            replaceFragment(FormFragment.newInstance())
        })
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.navigation_search -> {
                replaceFragment(FormFragment.newInstance())
                return true
            }
            R.id.navigation_history -> {
                replaceFragment(HistoryListFragment.newInstance(5))
                return true
            }
            R.id.navigation_info -> {
                replaceFragment(HistoryListFragment.newInstance(5))
                return true
            }
        }
        return false
    }

    fun replaceFragment(fragment: androidx.fragment.app.Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
    }
}