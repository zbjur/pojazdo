package com.pojazdo.steps

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.mauriciotogneri.greencoffee.GreenCoffeeSteps
import com.mauriciotogneri.greencoffee.annotations.And
import com.mauriciotogneri.greencoffee.annotations.Given
import com.mauriciotogneri.greencoffee.annotations.Then
import com.mauriciotogneri.greencoffee.annotations.When
import com.pojazdo.mobile.R
import com.pojazdo.mobile.ui.vehiclesummary.VehicleSummaryActivity
import org.junit.Rule

class VehicleSummaryRobot : GreenCoffeeSteps() {


    companion object {
        val VEHICLE_MODEL_EXAMPLE_HEADER = "Skoda"
        val TIME_LINE_HEADER = "Oś czasu"
        val RATING_HEADER = "Komentarze Użytkowników"
        val VEHICLE_AVERAGE_PRICE_HEADER = "Wartość Pojazdu"
        val SIMILAR_VEHICLES_HEADER = "Podobne pojazdy"
        val VEHICLES_OWNER_DETAILS_HEADER = "Dane sprzedającego"
        val MAP_HEADER_BUTTON = "Mapa"
    }

    @get:Rule
    val loginTestRule: ActivityTestRule<VehicleSummaryActivity> = ActivityTestRule(VehicleSummaryActivity::class.java, false, false)

    fun scrollToTimeLine() =
            RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                    hasDescendant(withText("Dane sprzedającego")))


    private fun scrollToVehicleOwnerDetails(): RecyclerViewActions.PositionableRecyclerViewAction {
        return RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                hasDescendant(withText("Liczba osi:")))
    }

    private fun scrollToVehicleRatedElement(): RecyclerViewActions.PositionableRecyclerViewAction {
        return RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                hasDescendant(withText("Karoseria")))
    }

    private fun scrollToVehicleDetails(): RecyclerViewActions.PositionableRecyclerViewAction {
        return RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                hasDescendant(withText(VEHICLE_MODEL_EXAMPLE_HEADER)))
    }

    private fun scrollToVehicleRating(): RecyclerViewActions.PositionableRecyclerViewAction {
        return RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>(
                hasDescendant(withText(RATING_HEADER)))
    }



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

    @And("^I introduce an valid registration number$")
    fun iIntroduceAnValidRegistraionNumber() {
        onView(withId(R.id.registerNumber)).perform(typeText("SCI 4666"))
    }

    @And("^I introduce an valid first registration date$")
    fun iIntroduceAnValidRegistraiotnDate() {
        onView(withId(R.id.registerDate)).perform(typeText("12.12.2018"))
    }

    @And("^I press the search$")
    fun iPressTheSearch() {
        onView(withId(R.id.registerDate)).perform(click())
        loginTestRule.launchActivity(null)
    }


    @Then("^I see vehicle rating$")
    fun isSeeVehicleSummaryHeaderOśCzasu() {

        onView(withId(R.id.recycler_view)).perform(scrollToVehicleRating())
        onView(withText(RATING_HEADER)).perform(click())
        onView(withId(R.id.recycler_view)).perform(scrollToVehicleRatedElement())

    }
}