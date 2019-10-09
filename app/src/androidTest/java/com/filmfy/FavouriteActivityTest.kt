package com.filmfy


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.filmfy.app.ui.favourite.FavouritesActivity
import com.filmfy.utils.films
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import com.filmfy.assertions.RecyclerViewMatcher

class FavouriteActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<FavouritesActivity>(FavouritesActivity::class.java)

    @Test
    fun show_favourites_list_and_hide_text_to_action() {
        addFilmsToRecyclerView()
        onView(withRecyclerView(R.id.recyclerViewMovieList).atPosition(0)).check(matches(isDisplayed()))
        onView(withId(R.id.textViewMovieListCallToAction)).check(matches(not(isDisplayed())))
    }

    @Test
    fun click_add_remove_favourite(){
        addFilmsToRecyclerView()
        onView(withRecyclerView(R.id.recyclerViewMovieList).atPosition(8)).check(matches(isDisplayed()))
        onView(withId(R.id.recyclerViewMovieList)).check(matches(hasDescendant(withId(R.id.imageViewMovieListItemFavorite)))).perform(click())
    }

    private fun addFilmsToRecyclerView(){
        activityRule.activity.runOnUiThread {
            activityRule.activity.showFilms(films())
        }
    }

    private fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
        return RecyclerViewMatcher(recyclerViewId)
    }
}