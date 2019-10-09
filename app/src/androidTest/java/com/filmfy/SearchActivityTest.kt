package com.filmfy

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.filmfy.app.idlingResource.EspressoTestingIdlResource
import com.filmfy.app.ui.favourite.FavouritesActivity
import com.filmfy.app.ui.filmDetail.FilmDetailActivity
import com.filmfy.app.ui.search.SearchActivity
import org.junit.*
import org.hamcrest.CoreMatchers
import com.filmfy.assertions.RecyclerViewMatcher

/**
 *
 *
 *
 * Some test could fail if you don't remove Animations or transitions from your mobile
 *
 *
 */

class SearchActivityTest {

    private var mIdlingResource: IdlingResource? = null

    @Rule
    @JvmField
    var activityRule = IntentsTestRule<SearchActivity>(SearchActivity::class.java)

    @Before
    fun registerIdlingResource() {
        IdlingRegistry.getInstance().register(EspressoTestingIdlResource.idlingResource)
        mIdlingResource = activityRule.activity.getIdlingResource()
    }

    @Test
    fun click_item_add_favourites(){
        onView(withId(R.id.editTextSearch)).perform(typeText("Action"), closeSoftKeyboard())
        onView(withId(R.id.buttonSearch)).perform(click())
        onView(withRecyclerView(R.id.recyclerViewMovieList).atPosition(0)).check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.recyclerViewMovieList)).check(matches(hasDescendant(withId(R.id.imageViewMovieListItemFavorite)))).perform(click())
    }

    @Test
    fun click_item_open_film_detail(){
        onView(withId(R.id.editTextSearch)).perform(typeText("Action"), closeSoftKeyboard())
        onView(withId(R.id.buttonSearch)).perform(click())
        onView(withRecyclerView(R.id.recyclerViewMovieList).atPosition(0)).check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.recyclerViewMovieList)).check(matches(hasDescendant(withId(R.id.imageViewMovieListItemStar)))).perform(click())
        intended(hasComponent(FilmDetailActivity::class.java.name))
    }

    @Test
    fun open_favourite(){
        onView(withId(R.id.menu_item_favorite)).perform(click())
        intended(hasComponent(FavouritesActivity::class.java.name))
    }

    @Test
    fun type_String_and_click_button() {
        onView(withId(R.id.editTextSearch)).perform(typeText("Action"), closeSoftKeyboard())
        onView(withId(R.id.editTextSearch)).perform(click())
    }

    @Test
    fun type_String_and_click_keyboard() {
        onView(withId(R.id.editTextSearch)).perform(typeText("Action"), closeSoftKeyboard())
        onView(withId(R.id.buttonSearch)).perform(click())
    }

    @Test
    fun check_toast_error_is_show(){
        activityRule.runOnUiThread {
            activityRule.activity.genreSearchError()
        }
        onView(ViewMatchers.withText(R.string.search_error)).inRoot(
            RootMatchers.withDecorView(
                CoreMatchers.not(CoreMatchers.`is`(activityRule.activity.window.decorView))
            )
        ).check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun load_and_display_genre_films() {
        onView(withId(R.id.editTextSearch)).perform(typeText("Action"), closeSoftKeyboard())
        onView(withId(R.id.buttonSearch)).perform(click())
        onView(withRecyclerView(R.id.recyclerViewMovieList).atPosition(0)).check(matches(ViewMatchers.isDisplayed()))
    }

    @After
    fun unregisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(EspressoTestingIdlResource.idlingResource)
    }

    private fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
        return RecyclerViewMatcher(recyclerViewId)
    }
}