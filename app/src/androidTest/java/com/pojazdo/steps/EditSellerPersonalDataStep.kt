package com.pojazdo.steps

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.mauriciotogneri.greencoffee.GreenCoffeeSteps
import com.mauriciotogneri.greencoffee.annotations.And
import com.mauriciotogneri.greencoffee.annotations.When
import com.pojazdo.mobile.R
import com.pojazdo.mobile.ui.vehiclesummary.VehicleSummaryActivity
import org.junit.Rule

class EditSellerPersonalDataStep : GreenCoffeeSteps() {

    @get:Rule
    val loginTestRule: ActivityTestRule<VehicleSummaryActivity> = ActivityTestRule(VehicleSummaryActivity::class.java, false, false)

    @When("^I move to seller data section$")
    fun iMoveToSellerDataSection() {
        onView(withId(R.id.edit_user_data_button)).perform(click())
    }

    @And("^I tap edit button$")
    fun ITapEditButton() {
        onView(withId(R.id.edit_user_data_button)).perform(click())
    }

    @And("^I see \"Edit screen\"$")
    fun iSeeEditScreen() {
        onView(withId(R.id.edit_user_data_button)).perform(click())
    }

    @And("^I enter valid name$")
    fun iEnterValidName() {
        onView(withId(R.id.edit_user_data_button)).perform(click())
    }

   /* @And("^I enter valid address$")
    fun iEnterValidAddress() {
        onView(withId(R.sellerId.edit_user_data_button)).perform(click())
    }

    @And("^I enter valid phone number$")
    fun iEnterValidPhoneNumber() {
        onView(withId(R.sellerId.edit_user_data_button)).perform(click())
    }

    @And("^I enter valid email adress$")
    fun iEnterValidEmailAdress() {
        onView(withId(R.sellerId.edit_user_data_button)).perform(click())
    }

    @And("^I Press save button$")
    fun iPressSaveButton() {
        onView(withId(R.sellerId.edit_user_data_button)).perform(click())
    }

    @And("^ I see summary screen with entered seller personal data$")
    fun iSeeSummaryScreenWithEnteredSellerPersonalData() {
        onView(withId(R.sellerId.edit_user_data_button)).perform(click())
    }*/
}