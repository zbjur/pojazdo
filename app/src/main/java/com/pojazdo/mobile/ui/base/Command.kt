package com.pojazdo.mobile.ui.base

import com.pojazdo.api.database.vehicleadditionalinformation.model.Seller
import com.pojazdo.mobile.ui.vehiclesummary.model.modelsection.VehicleSections

sealed class Command {
    object ShowProgress : Command()
    object HideProgress : Command()
    class NavigateToVehicleDecodedInfo(val registrationNumber: String, val vin: String, val firstRegistrationDate: String) : Command()
    class PopulateVehicleSummaryViewWithData(val vehicleInformationList: MutableList<VehicleSections>?) : Command()
    object NavigateToVehicleSummaryInfoScreenEvent : Command()
    class NavigateToEditPersonalSellerDataScreenEvent(val seller: Seller?) : Command()
    object NavigateToScannerView : Command()
    class NavigateToVehicleResultView(val registrationNumber: String, val vin: String, val firstRegistrationDate: String) : Command()
    class Error(val errorMessage: String?) : Command()
    class ShowPersonaSellerData(val seller: Seller?) : Command()
    class ShowPersonaSellerDataEditView(val seller: Seller?) : Command()
}
