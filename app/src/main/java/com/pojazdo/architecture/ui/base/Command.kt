package com.pojazdo.architecture.ui.base

import com.pojazdo.api.network.vehicleinformation.model.VehicleInformationPojo

sealed class Command {
    class ShowProgress : Command()
    class HideProgress : Command()
    class ShowVehicleDecodedInfo(val registrationNumber: String, val vin: String, val firstRegistrationDate: String) : Command()
    class ShowVehicleInfo(val vehicleInformationPojo: VehicleInformationPojo?) : Command()
    class NavigateToScannerView : Command()
    class NavigateToVehicleResultView(val registrationNumber: String, val vin: String, val firstRegistrationDate: String) : Command()
    class Error(val errorMessage: String?) : Command()
}