package com.octagonafrica.africa.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import com.octagonafrica.africa.R
import com.octagonafrica.africa.fragments.*


class MainActivity : AppCompatActivity() {
    var chipNavigationBar: ChipNavigationBar? = null
    lateinit var fragmentTitle:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //fragmentTitle --> Title for each fragment
        fragmentTitle = findViewById(R.id.fragmentTitle)
        fragmentTitle.text = "DASHBOARD"
        chipNavigationBar = findViewById(R.id.mainBottomNavigationView)
        chipNavigationBar!!.setItemSelected(R.id.ic_dashboard, true)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentPager, DashboardFragment()).commit()

        bottomMenu()
    }

    //Function to navigate through the nav bar
    private fun bottomMenu() {
        chipNavigationBar?.setOnItemSelectedListener(object :
            ChipNavigationBar.OnItemSelectedListener {
            override fun onItemSelected(i: Int) {
                var fragment: Fragment? = null
                when (i) {
                    R.id.ic_dashboard ->{
                        fragment = DashboardFragment()
                        fragmentTitle.text = "DASHBOARD"
                    }
                    R.id.ic_accounts ->{
                        fragment = AccountsFragment()
                        fragmentTitle.text = "ACCOUNTS"
                    }
                    R.id.ic_products -> {
                        fragment = ProductsFragment()
                        fragmentTitle.text = "PRODUCTS"
                    }
                    R.id.ic_help -> {
                        fragment = HelpFragmet()
                        fragmentTitle.text = "HELP"
                    }
                    R.id.ic_profile -> {
                        fragment = ProfileFragment()
                        fragmentTitle.text = "PROFILE"
                    }
                }
                supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.fragmentPager,
                        fragment!!
                    ).commit()
            }
        })
    }
}