package com.example.metricconverter.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.example.metricconverter.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_currency_converter.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.app_bar_settings.*

class MainActivity : BaseActivity(),  NavigationView.OnNavigationItemSelectedListener {

  private var doubleBackToExitPressedOnce = false
  private lateinit var mSharedPreferences: SharedPreferences

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
   setupActionBar(toolbar_main_activity, drawer_layout)

    //startActivity(Intent(this@MainActivity, CurrencyConverter::class.java))
    // Assign the NavigationView.OnNavigationItemSelectedListener to navigation view.
    main_nav_view.setNavigationItemSelectedListener(this)

    // Initialize the SharedPreferences variable
    mSharedPreferences = getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE)
    val radioValue = mSharedPreferences.getString(Constants.RADIO_GROUP_DATA, "")
   // Toast.makeText(applicationContext, radioValue, Toast.LENGTH_SHORT).show()
    if(radioValue.isNullOrEmpty()){
      startActivity(Intent(this@MainActivity, CurrencyConverter::class.java))
    }
    else if(radioValue == "Weight Converter") {
      startActivity(Intent(this@MainActivity, WeightConverter::class.java))
    }
    else if(radioValue == "Length Converter") {
      startActivity(Intent(this@MainActivity, LengthConverter::class.java))
    }else if(radioValue == "Temperature Converter") {
      startActivity(Intent(this@MainActivity, TemperatureConverter::class.java))
    }else if(radioValue == "Currency Converter") {
      startActivity(Intent(this@MainActivity, CurrencyConverter::class.java))
    }


  }

  override fun onBackPressed() {
    if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
      drawer_layout.closeDrawer(GravityCompat.START)
    } else {
      // A double back press function is added in Base Activity.
      doubleBackToExit()
    }
  }

  private fun doubleBackToExit() {
    if (doubleBackToExitPressedOnce) {
        super.onBackPressed()
        return
      }

      this.doubleBackToExitPressedOnce = true
      Toast.makeText(
        this,
        resources.getString(R.string.please_click_back_again_to_exit),
        Toast.LENGTH_SHORT
      ).show()

      Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
  }

  override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
    when (menuItem.itemId) {
      R.id.nav_home -> {

//        val radioValue = mSharedPreferences.getString(Constants.RADIO_GROUP_DATA, "")
//        if(radioValue.isNullOrEmpty()){
//          startActivity(Intent(this@MainActivity, CurrencyConverter::class.java))
//        }
        //startActivity(Intent(this@MainActivity, MyProfileActivity::class.java))
      }

      R.id.nav_settings -> {

        // Send the user to the settings screen of the application.
        val intent = Intent(this, SettingsActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
      }
    }
    drawer_layout.closeDrawer(GravityCompat.START)
    return true
  }

//  private fun setupActionBar(toolbar: Toolbar) {
//
//    setSupportActionBar(toolbar_settings_activity)
//    toolbar_settings_activity.setNavigationIcon(R.drawable.ic_action_navigation_menu)
//
//    toolbar_settings_activity.setNavigationOnClickListener {
//      toggleDrawer()
//    }
//  }
//
//  private fun toggleDrawer() {
//
//    if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
//      drawer_layout.closeDrawer(GravityCompat.START)
//    } else {
//      drawer_layout.openDrawer(GravityCompat.START)
//    }
//  }

}