package com.filmfy.app.base

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import com.filmfy.R
import kotlinx.android.synthetic.main.generic_toolbar.*

abstract class GenericToolbarActivity : AppCompatActivity() {


    fun configureActionBar(title : String) {
        if (toolbar != null) {
            toolbar?.title = title
            setSupportActionBar(toolbar!!)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            val upArrow = AppCompatResources.getDrawable(this, R.drawable.ic_ico_white)
            upArrow?.setColorFilter(ContextCompat.getColor(this, R.color.textColorPrimary), PorterDuff.Mode.SRC_ATOP)
            supportActionBar!!.setHomeAsUpIndicator(upArrow)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}