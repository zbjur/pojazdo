package com.pojazdo.steps

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import com.mauriciotogneri.greencoffee.GreenCoffeeSteps
import com.mauriciotogneri.greencoffee.annotations.And
import com.mauriciotogneri.greencoffee.annotations.Given
import com.mauriciotogneri.greencoffee.annotations.When
import com.pojazdo.architecture.R
import com.pojazdo.architecture.ui.summary.VehicleSummaryActivity
import org.junit.Rule

class StartUpStep : GreenCoffeeSteps() {

    @get:Rule
    val loginTestRule: ActivityTestRule<VehicleSummaryActivity> = ActivityTestRule(VehicleSummaryActivity::class.java, false, false)



    @Given("^I see an empty search form$")
    fun iSeeAnEmptySearchForm() {
        onView(withId(R.id.registerNumber)).check(matches(isDisplayed()))
        onView(withId(R.id.vinNumber)).check(matches(isDisplayed()))
        onView(withId(R.id.registerDate)).check(matches(isDisplayed()))
    }

    @When("^I introduce an valid vin$")
    fun iIntroduceAnValidVin() {
        onView(withId(R.id.vinNumber)).perform(typeText("FSSRW535WRSFA"))
    }

    @When("^I introduce an valid registration number$")
    fun iIntroduceAnValidRegistraionNumber() {
        onView(withId(R.id.registerNumber)).perform(typeText("SCI 4666"))
    }

    @When("^I introduce an valid first registration date$")
    fun iIntroduceAnValidRegistraiotnDate() {
        onView(withId(R.id.registerDate)).perform(typeText("12.12.2018"))
    }

    @And("^I press the search$")
    fun andIPressTheSearch() {
        onView(withId(R.id.registerDate)).perform(click())
        loginTestRule.launchActivity(null)
    }
}