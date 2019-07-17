package com.pojazdo.architecture.ui.summary

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.pojazdo.architecture.R
import com.pojazdo.architecture.extension.viewModelProvider
import com.pojazdo.architecture.ui.base.Command
import com.pojazdo.architecture.ui.platform.BaseActivity
import com.pojazdo.architecture.ui.summary.list.VehicleSummaryInformationAdapter
import com.pojazdo.architecture.ui.summary.model.*
import kotlinx.android.synthetic.main.activity_vehicle_summary.*
import javax.inject.Inject

class VehicleSummaryActivity : BaseActivity() {

    companion object {
        const val REGISTER_NUMBER = "register_number"
        const val REGISTRATION_DATE = "registration_date"
        const val VIN = "vin"

        fun createIntent(context: Context, registerNumber: String, registrationDate: String, vin: String) = Intent(context, VehicleSummaryActivity::class.java)
                .putExtra(REGISTER_NUMBER, registerNumber)
                .putExtra(REGISTRATION_DATE, registrationDate)
                .putExtra(VIN, vin)
    }

    lateinit var vehicleSummaryInformationAdapter: VehicleSummaryInformationAdapter

    @Inject
    lateinit var vehicleInformationViewModel: VehicleInformationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vehicle_summary)
        appComponent.inject(this)
        vehicleInformationViewModel = viewModelProvider(viewModelFactory)
        vehicleInformationViewModel = ViewModelProviders.of(this).get(VehicleInformationViewModel::class.java)
        initObservers()
        readVehicleData(intent, savedInstanceState)

        val layoutManager = LinearLayoutManager(this)
        recycler_view.layoutManager = layoutManager
    }

    override fun layoutId() = R.layout.activity_vehicle_summary

    private fun readVehicleData(intent: Intent?, savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            checkVehicle(intent)
            vehicleInformationViewModel.checkVehicleHistory("", "", "")
        }
    }

    private fun initObservers() {
        vehicleInformationViewModel.viewState.observe(this, Observer {
            renderViewState(it)
        })
    }

    private fun renderViewState(it: com.pojazdo.architecture.ui.Event<Command>?) {
        it?.getContentIfNotHandled()?.let {
            when (it) {
                is Command.ShowVehicleInfo -> showVehicleInformation()
                is Command.ShowProgress -> showProgressBar()
                is Command.HideProgress -> hideProgressBar()
                is Command.Error -> showErrorView(it.errorMessage)
            }
        }
    }

    private fun showVehicleInformation() {
        vehicleSummaryInformationAdapter = VehicleSummaryInformationAdapter(this, makeSections())
        recycler_view.adapter = vehicleSummaryInformationAdapter
    }

    private fun hideProgressBar() {}

    private fun showProgressBar() {}

    private fun showErrorView(errorMessage: String?) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }


    private fun checkVehicle(intent: Intent?) {
        intent?.getStringExtra(REGISTER_NUMBER)
        intent?.getStringExtra(VIN)
        intent?.getStringExtra(REGISTRATION_DATE)
    }

    private fun makeSections(): MutableList<VehicleSections> {
        return mutableListOf(
                VehicleSections("Głowne informacje", makeVehicleMainInfoSubsection()),
                VehicleSections("Historia Pojazdu ", makeVehicleHistorySubsection()),
                VehicleSections("Komentarze Użytkowników", makeVehicleRatingSubsection()),
                VehicleSections("Wartość Pojazdu", makeVehiclePriceSubsection()),
                VehicleSections("Podobne poazdy", makeVehicleAdsSubsection()),
                VehicleSections("Lokalizacja Pojazdu", makeVehicleLocationSubsection()))
    }

    private fun makeVehicleMainInfoSubsection(): MutableList<VehicleSubsection> {
        return mutableListOf(
                VehicleSubsection(VehicleMainInfoSubsections("Skoda", "Key", "Roomster")))
    }


    private fun makeVehicleHistorySubsection(): MutableList<VehicleSubsection> {

        return mutableListOf(
                VehicleSubsection(VehicleTimeLine("12.03.2019", "Rodzaj badania: okresowe", listOf(Event("Właściciel:", "Osoba fizyczna"), Event("Województwo, w którym pojazd zarejestrowano:", "warmińsko-mazurskie")))),
                VehicleSubsection(VehicleTimeLine("12.03.2018", "Pierwsza rejestracja w Polsce", listOf(Event("Zmiana właściciela", "")))),
                VehicleSubsection(VehicleTimeLine("12.03.2017", "Rodzaj badania: okresowe", listOf(Event("", "")))),
                VehicleSubsection(VehicleTimeLine("12.03.2016", "Rodzaj badania: okresowe", listOf(Event("", "")))),
                VehicleSubsection(VehicleTimeLine("12.03.2015", "Rodzaj badania: okresowe", listOf(Event("", "")))),
                VehicleSubsection(VehicleTimeLine("12.03.2014", "Rodzaj badania: okresowe", listOf(Event("", "")))))
    }

    private fun makeVehicleRatingSubsection(): MutableList<VehicleSubsection> {
        return mutableListOf(
                VehicleSubsection(VehicleRatingSection("Tomasz", "Skoda", "Roomster", "4.5", "Auto było dobrane do potrzeb (rodzina z dwójką małych dzieci) i budżetu. Na razie zrobione 4tys, (z czego 3,5tys podczas wakacji). To co niesamowicie zaskakuje, to pakowność.")),
                VehicleSubsection(VehicleRatingSection("Zbigniew", "Skoda", "Roomster", "3.8", "Auto było dobrane do potrzeb (rodzina z dwójką małych dzieci) i budżetu. Na razie zrobione 4tys, (z czego 3,5tys podczas wakacji). To co niesamowicie zaskakuje, to pakowność.")),
                VehicleSubsection(VehicleRatingSection("Jan", "Skoda", "Roomster", "4.5", "Auto było dobrane do potrzeb (rodzina z dwójką małych dzieci) i budżetu. Na razie zrobione 4tys, (z czego 3,5tys podczas wakacji). To co niesamowicie zaskakuje, to pakowność.")))

    }

    private fun makeVehiclePriceSubsection(): MutableList<VehicleSubsection> {
        return mutableListOf(
                VehicleSubsection(VehiclePriceSection("15,000", "25,000", "20,000")))
    }

    private fun makeVehicleAdsSubsection(): MutableList<VehicleSubsection> {
        return mutableListOf(
                VehicleSubsection(VehicleAdSection(makeVehicleAdsList()))
        )
    }

    private fun makeVehicleAdsList(): MutableList<VehicleAd> {
        return mutableListOf(
                VehicleAd("Skoda", "Roomster", "Test 1", "1400", "25 000"),
                VehicleAd("Skoda", "Roomster", "Test 2", "1400", "25 000"),
                VehicleAd("Skoda", "Roomster", "Test 3", "1400", "25 000"),
                VehicleAd("Skoda", "Roomster", "Test 3", "1400", "25 000"),
                VehicleAd("Skoda", "Roomster", "Test 3", "1400", "25 000"),
                VehicleAd("Skoda", "Roomster", "Test 3", "1400", "25 000"),
                VehicleAd("Skoda", "Roomster", "Test 3", "1400", "25 000"),
                VehicleAd("Skoda", "Roomster", "Test 3", "1400", "25 000")
        )
    }


    private fun makeVehicleLocationSubsection(): MutableList<VehicleSubsection> {
        return mutableListOf(
                VehicleSubsection(VehicleLocationSection("2000", "Test 1")))
    }

}
