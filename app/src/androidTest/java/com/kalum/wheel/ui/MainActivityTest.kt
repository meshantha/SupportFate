package com.kalum.wheel.ui

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import com.kalum.wheel.R
import com.kalum.wheel.util.RecyclerViewItemCountAssertion.Companion.hasItemCount
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnit


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java, true, true)

    @Rule
    @JvmField
    var mockitoRule = MockitoJUnit.rule()


    @Test
    fun listUsersWithSuccess() {
        onView(allOf<View>(
                withId(R.id.recycler_view),
                isDescendantOfA(withId(R.id.list_users))
        )).check(hasItemCount(10))
    }

    @Test
    fun listSchedulesWithSuccess() {

    }

}