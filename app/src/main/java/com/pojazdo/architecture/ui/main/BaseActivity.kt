package com.pojazdo.architecture.ui.main

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import com.pojazdo.architecture.R
abstract class BaseActivity : AppCompatActivity() {


    protected var navigation: BottomNavigationView? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_search -> {
             //   message.setGroupTitle(R.string.title_search)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_history -> {
            //    message.setGroupTitle(R.string.title_scan)
                IntentIntegrator(this).initiateScan();
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_info -> {
                //message.setGroupTitle(R.string.title_history)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentViewId())

        navigation?.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    abstract fun getContentViewId(): Int
    abstract fun getNavigationMenuItemId(): Int
}
