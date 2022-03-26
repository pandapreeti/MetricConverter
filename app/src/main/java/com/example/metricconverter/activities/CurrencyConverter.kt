package com.example.metricconverter.activities

import android.os.Bundle
import android.view.View
import com.example.metricconverter.R
import kotlinx.android.synthetic.main.activity_currency_converter.*
import kotlinx.android.synthetic.main.activity_length_converter.*
import kotlinx.android.synthetic.main.app_bar_currency.*

class CurrencyConverter : BaseActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_currency_converter)
    setupActionBar(toolbar_currency_activity, currency_drawer_layout)
    currency_nav_view.setNavigationItemSelectedListener(this)
    val actionbar = supportActionBar
    if(actionbar!=null) {
      //actionbar.setDisplayHomeAsUpEnabled(true)
      actionbar.title = "Currency Converter"
    }


    btnCalculateUnits.setOnClickListener {
      if(validateField()) {
         val dollarValue: Float = etMetricUnitWeight.text.toString().toFloat()
         displayResult(dollarValue)
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

  private fun displayResult(dollar: Float) {
    val euro = 0.91 * dollar
    val indianRupee= 76.28 * dollar
    val australianDollar = 1.35 * dollar
    val canadianDollar = 1.25 * dollar

    llDisplayCurrencyResult.visibility = View.VISIBLE

    tvCurrencyHeader.text = ""+ dollar + "US Dollar ="
    tvEuroValue.text = euro.toString()
    tvEuro.text = "EUR (Euro)"
    tvIndiaRupee.text = indianRupee.toString()
    tvRupee.text = "IND (Indian Rupee)"
    tvAustralianDollar.text = australianDollar.toString()
    tvAustralia.text = "AUS (Dollar)"
    tvCanadianDollar.text = canadianDollar.toString()
    tvCanada.text = "CAD (Canadian Dollar)"
  }
}