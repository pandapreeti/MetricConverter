package com.example.metricconverter.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.core.view.GravityCompat
import com.example.metricconverter.R
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_weight_converter.*
import kotlinx.android.synthetic.main.app_bar_weight.*

class WeightConverter : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_weight_converter)
    weight_nav_view.setNavigationItemSelectedListener(this)
    setupActionBar(toolbar_weight_activity, weight_drawer_layout)
    toolbar_weight_activity.title = "Weight Converter"
    val actionbar = supportActionBar
    if(actionbar!=null) {
      actionbar.title = "Weight Converter"
    }
    weight_drawer_layout.closeDrawer(GravityCompat.START)
    btnCalculateUnits.setOnClickListener {
      if(validateField()) {
        val poundsValue: Float = etMetricUnitWeight.text.toString().toFloat()
        displayResult(poundsValue)
      }
    }
  }

  private fun displayResult(poundsValue: Float) {
    val kiloGramVal = 0.453592 * poundsValue
    val gramVal = 453.592 * poundsValue
    val ounchVal = 15.999 * poundsValue

    llDisplayWeightResult.visibility = View.VISIBLE
    tvKiloGramValue.text = kiloGramVal.toString()
    tvKg.text = "Kg"
    tvGramValue.text = gramVal.toString()
    tvGm.text = "gm"
    tvOunceVal.text = ounchVal.toString()
    tvOunce.text = "ounch"
  }

  private fun validateField(): Boolean {
    var isValid = true

    if (etMetricUnitWeight.text.toString().isEmpty()) {
      isValid = false
    }

    return isValid
  }

//  override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
//    when (menuItem.itemId) {
//      R.id.nav_home -> {
//
////        val radioValue = mSharedPreferences.getString(Constants.RADIO_GROUP_DATA, "")
////        if(radioValue.isNullOrEmpty()){
////          startActivity(Intent(this@MainActivity, CurrencyConverter::class.java))
////        }
//        //startActivity(Intent(this@MainActivity, MyProfileActivity::class.java))
//      }
//
//      R.id.nav_settings -> {
//
//        // Send the user to the settings screen of the application.
//        val intent = Intent(this, SettingsActivity::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
//        startActivity(intent)
//      }
//    }
//   // weight_drawer_layout.closeDrawer(GravityCompat.START)
//    return true
//  }


}