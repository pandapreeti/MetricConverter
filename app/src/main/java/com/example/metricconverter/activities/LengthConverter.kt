package com.example.metricconverter.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.metricconverter.R
import kotlinx.android.synthetic.main.activity_length_converter.*
import kotlinx.android.synthetic.main.app_bar_length.*

class LengthConverter : BaseActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_length_converter)
    setupActionBar(toolbar_length_activity, length_drawer_layout)
    length_nav_view.setNavigationItemSelectedListener(this)
    val actionbar = supportActionBar
    if(actionbar!=null) {
      actionbar.title = "Length Converter"
    }

    btnCalculateUnits.setOnClickListener {
      if(validateField()) {
        val lengthValue: Float = etMetricUnitWeight.text.toString().toFloat()
        displayResult(lengthValue)
      }
    }
  }

  private fun displayResult(lengthValue: Float) {
    val kilometersVal = 1.60934 * lengthValue
    val metersVal = 1609.33999 * lengthValue
    val foot = 5279.9868 * lengthValue
    val inches = 63359.8425 * lengthValue

    llDisplayLengthResult.visibility = View.VISIBLE
    tvLengthHeader.text = "$lengthValue miles ="
    tvKiloMetersValue.text = kilometersVal.toString()
    tvKm.text = "Km"
    tvMeters.text = metersVal.toString()
    tvMtr.text = "Meter"
    tvFoot.text = foot.toString()
    tvFt.text = "Ft"
    tvInches.text = inches.toString()
    tvIn.text = "Inch"
  }

  private fun validateField(): Boolean {
    var isValid = true

    if (etMetricUnitWeight.text.toString().isEmpty()) {
      isValid = false
    }

    return isValid
  }

}