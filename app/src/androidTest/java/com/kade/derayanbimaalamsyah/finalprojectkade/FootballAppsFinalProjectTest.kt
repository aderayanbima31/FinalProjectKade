package com.kade.derayanbimaalamsyah.finalprojectkade

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.v7.widget.RecyclerView
import com.kade.derayanbimaalamsyah.finalprojectkade.R.id.*
import com.kade.derayanbimaalamsyah.finalprojectkade.view.baseuianko.activities.home.HomeActivity
import org.junit.Rule
import org.junit.Test

class FootballAppsFinalProjectTest {
    @Rule
    @JvmField var activityRule = ActivityTestRule(HomeActivity::class.java)
    private val wait: Long = 3000

    @Test
    fun testRecyclerViewBehaviour() {
        Thread.sleep(wait)
        Espresso.onView(ViewMatchers.withId(rvPastEvent)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(rvPastEvent)).perform(RecyclerViewActions.
                scrollToPosition<RecyclerView.ViewHolder>(8))
        Espresso.onView(ViewMatchers.withId(rvPastEvent)).perform(
                RecyclerViewActions.actionOnItemAtPosition<
                        RecyclerView.ViewHolder>(8, ViewActions.click()))
    }

    @Test
    fun testAppBehaviourUI() {
        Thread.sleep(wait)

        Espresso.onView(ViewMatchers.withId(container)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(navigation_matches)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(navigation_teams)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(navigation_favorites)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(navigation_teams)).perform(ViewActions.click())

        Thread.sleep(wait)
        Espresso.onView(ViewMatchers.withId(rvListTeams)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(rvListTeams))
                .perform(RecyclerViewActions.actionOnItemAtPosition
                <RecyclerView.ViewHolder>(5, ViewActions.click()));

        Thread.sleep(wait)
        Espresso.onView(ViewMatchers.withId(lyTeamDetail)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(add_to_favorite)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(add_to_favorite)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(add_to_favorite)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(add_to_favorite)).perform(ViewActions.click())

        Espresso.pressBack()

        Thread.sleep(wait)

        Espresso.onView(ViewMatchers.withId(navigation)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(navigation_favorites)).perform(ViewActions.click())
    }
}