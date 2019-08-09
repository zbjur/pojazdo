package com.pojazdo.features

import androidx.test.rule.ActivityTestRule
import com.mauriciotogneri.greencoffee.GreenCoffeeConfig
import com.mauriciotogneri.greencoffee.GreenCoffeeTest
import com.mauriciotogneri.greencoffee.ScenarioConfig
import com.pojazdo.architecture.ui.main.HomeActivity
import com.pojazdo.steps.StartUpStep
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.io.IOException
import java.util.*


@RunWith(Parameterized::class)
class StartUpFeatureFeatureTest(scenarioConfig: ScenarioConfig) : GreenCoffeeTest(scenarioConfig) {

    @Rule @JvmField var activityTestRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun test() {
        start(StartUpStep())
    }

    companion object {
        @Parameterized.Parameters
        @Throws(IOException::class)
        @JvmStatic
        fun scenarios(): Iterable<ScenarioConfig> {
            return GreenCoffeeConfig() // folder to place the screenshot if a test fails
                    .withFeatureFromAssets("assets/startup.feature")
                    .scenarios(Locale("en", "GB"))
        }
    }
}