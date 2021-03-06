package com.example.metricconverter.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.metricconverter.R
import kotlinx.android.synthetic.main.activity_temperature_converter.*
import kotlinx.android.synthetic.main.app_bar_length.*
import kotlinx.android.synthetic.main.app_bar_temperature.*
import kotlinx.android.synthetic.main.app_bar_temperature.btnCalculateUnits
import kotlinx.android.synthetic.main.app_bar_temperature.etMetricUnitWeight

class TemperatureConverter : BaseActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_temperature_converter)

    setupActionBar(toolbar_temperature_activity, temperature_drawer_layout)
    temperature_nav_view.setNavigationItemSelectedListener(this)
    val actionbar = supportActionBar
    if(actionbar!=null) {
      actionbar.title = "Temperature Converter"
    }

    btnCalculateUnits.setOnClickListener {
      if(validateField()) {
        val poundsValue: Float = etMetricUnitWeight.text.toString().toFloat()
        displayResult(poundsValue)
      }
    }
  }

  private fun validateField(): Boolean {
    var isValid = true

    if (etMetricUnitWeight.text.toString().isEmpty()) {
      isValid = false
    }

    return isValid
  }

  private fun displayResult(farehneit: Float) {

    val celciusVal =  ((farehneit -32)*5)/9
    val kelvinVal = celciusVal + 273
    etMetricUnitWeight.text = null
    llDisplayTemperatureResult.visibility = View.VISIBLE
    tvTempHeader.text = "$farehneit Farenheit = "
    tvCeliusValue.text = celciusVal.toString()
    tvC.text = "\u2103"
    tvKelvin.text = kelvinVal.toString()
    tvK.text = "K"
  }
}