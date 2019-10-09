package com.filmfy

import android.content.Intent
import android.widget.TextView
import androidx.test.rule.ActivityTestRule
import com.filmfy.utils.filmFacke
import org.junit.*
import org.hamcrest.core.AllOf.allOf
import org.hamcrest.core.IsInstanceOf.instanceOf
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import com.filmfy.app.ui.filmDetail.FilmDetailActivity
import com.filmfy.app.utils.ArgumentNameConfig
import org.hamcrest.CoreMatchers


class DetailActivityTest{

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<FilmDetailActivity>(FilmDetailActivity::class.java, true, false)


    @Before
    @Throws(Exception::class)
    fun setUp() {
        val intent = Intent()
        intent.putExtra(ArgumentNameConfig.FILM, filmFacke())
        activityRule.launchActivity(intent)
    }

    @Test
    fun check_intent_is_received_and_show_elements(){
        onView(allOf(instanceOf(TextView::class.java), withParent(withId(R.id.toolbar)))).check(matches(withText("The incredible Hulk")))
    }

    @Test
    fun check_toast_error_is_show(){
        activityRule.runOnUiThread {
            activityRule.activity.errorDisplayingDetail()
        }
        onView(withText(R.string.error_display_data)).inRoot(
            RootMatchers.withDecorView(
                CoreMatchers.not(CoreMatchers.`is`(activityRule.activity.window.decorView))
            )
        ).check(matches(isDisplayed()))
    }
}