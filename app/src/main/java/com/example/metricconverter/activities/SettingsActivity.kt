package com.example.metricconverter.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.metricconverter.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.app_bar_settings.*


class SettingsActivity : BaseActivity() {

  private lateinit var mSharedPreferences: SharedPreferences


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_settings)
    settings_nav_view.setNavigationItemSelectedListener(this)
    setupActionBar(toolbar_settings_activity, settings_drawer_layout)
    val actionbar = supportActionBar
    if(actionbar!=null) {
      actionbar.title = "Settings"
    }

    var radioValue: String = ""
    mSharedPreferences = getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE)
    val radio = mSharedPreferences.getString(Constants.RADIO_GROUP_DATA, "")
    if(radio.isNullOrEmpty())
       cur.isChecked = true
    else if(radio == "Weight Converter") {
      wt.isChecked = true
    }
    else if(radio == "Length Converter") {
      len.isChecked = true
    }else if(radio == "Temperature Converter") {
      temp.isChecked = true
    }else if(radio == "Currency Converter") {
      cur.isChecked = true
    }

    val radioGroup = findViewById<View>(R.id.radioGrpId) as RadioGroup
    radioGroup.setOnCheckedChangeListener { group, checkedId ->
      val checkedRadioButton = findViewById<View>(checkedId) as RadioButton
      saveRadioButton(checkedRadioButton)
      val text = checkedRadioButton.text.toString()
      radioValue = text
      mSharedPreferences = getSharedPreferences(Constants.PREFERENCE_NAME, Context.MODE_PRIVATE)

      val editor = mSharedPreferences.edit()
      editor.putString(Constants.RADIO_GROUP_DATA, radioValue)
      editor.apply()
      Toast.makeText(applicationContext, "Default set to $text", Toast.LENGTH_SHORT).show()
    }


  }

  private fun saveRadioButton(checkedRadioButton: Button) {

  }

//  private fun setupActionBar() {
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