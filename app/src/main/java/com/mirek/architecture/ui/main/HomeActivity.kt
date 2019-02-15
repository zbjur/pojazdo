package com.mirek.architecture.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.mirek.architecture.R
import com.mirek.architecture.ui.form.FormFragment
import com.mirek.architecture.ui.history.HistoryListFragment
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

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
    }
}