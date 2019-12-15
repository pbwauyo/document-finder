package com.pirlo.documentfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.pirlo.documentfinder.tabs.ContactUs
import com.pirlo.documentfinder.tabs.Home
import com.pirlo.documentfinder.tabs.ProcessBarcode
import com.pirlo.documentfinder.tabs.Profile

class MainActivity : AppCompatActivity() {
    var bottomNavView: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavView = findViewById(R.id.bottom_nav_bar)
    }

    override fun onStart() {
        super.onStart()

        bottomNavView?.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.bottom_nav_bar_home -> openFragment(Home())
                R.id.bottom_nav_bar_search -> openFragment(ProcessBarcode())
                R.id.bottom_nav_bar_profile -> openFragment(Profile())
                R.id.bottom_nav_bar_contact_us -> openFragment(ContactUs())
                else -> false
            }
        }
    }

    private fun openFragment(fragment: Fragment): Boolean{
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment, fragment.javaClass.simpleName)
            .commit()
        return true
    }
}
