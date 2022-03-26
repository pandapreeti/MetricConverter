package com.example.metricconverter.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar

import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.metricconverter.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_settings.*

open class BaseActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

  private lateinit var mSharedPreferences: SharedPreferences
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_base)

  }

   fun setupActionBar(toolbar: Toolbar, drawerId: DrawerLayout) {

    setSupportActionBar(toolbar)
    toolbar.setNavigationIcon(R.drawable.ic_action_navigation_menu)
    toolbar.setNavigationOnClickListener {
      toggleDrawer(drawerId)
    }
  }

   fun toggleDrawer(drawerId: DrawerLayout) {

    if (drawerId.isDrawerOpen(GravityCompat.START)) {
      drawerId.closeDrawer(GravityCompat.START)
    } else {
      drawerId.openDrawer(GravityCompat.START)
    }
  }

  override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
    when (menuItem.itemId) {
      R.id.nav_home -> {
        mSharedPreferences = getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE)
        val radioValue = mSharedPreferences.getString(Constants.RADIO_GROUP_DATA, "")
        if(radioValue.isNullOrEmpty()){
          startActivity(Intent(this, CurrencyConverter::class.java))
        }
        else if(radioValue == "Weight Converter") {
          startActivity(Intent(this, WeightConverter::class.java))
        }
        else if(radioValue == "Length Converter") {
          startActivity(Intent(this, LengthConverter::class.java))
        }else if(radioValue == "Temperature Converter") {
          startActivity(Intent(this, TemperatureConverter::class.java))
        }else if(radioValue == "Currency Converter") {
          startActivity(Intent(this, CurrencyConverter::class.java))
        }

//        val radioValue = mSharedPreferences.getString(Constants.RADIO_GROUP_DATA, "")
//        if(radioValue.isNullOrEmpty()){
//          startActivity(Intent(this@MainActivity, CurrencyConverter::class.java))
//        }
        //startActivity(Intent(this@MainActivity, MyProfileActivity::class.java))
      }

      R.id.nav_settings -> {

        // Send the user to the settings screen of the application.
        val intent = Intent(this, SettingsActivity::class.java)
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
      }
    }
    //drawer_layout.closeDrawer(GravityCompat.START)
    return true
  }
}