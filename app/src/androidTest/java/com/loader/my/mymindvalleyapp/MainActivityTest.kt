package com.loader.my.mymindvalleyapp


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val viewGroup = onView(
                allOf(withId(R.id.itemmindlayout),
                        childAtPosition(
                                allOf(withId(android.R.id.list),
                                        childAtPosition(
                                                withId(R.id.swiperefresh),
                                                0)),
                                0),
                        isDisplayed()))
        viewGroup.check(matches(isDisplayed()))

        val textView = onView(
                allOf(withId(R.id.txtcreatedat), withText("2016-05-29T15:37:01-04:00"),
                        childAtPosition(
                                allOf(withId(R.id.itemmindlayout),
                                        childAtPosition(
                                                withId(android.R.id.list),
                                                2)),
                                2),
                        isDisplayed()))
        textView.check(matches(withText("2016-05-29T15:37:01-04:00")))
    }

    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
