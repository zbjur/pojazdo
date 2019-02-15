package com.mirek.architecture.ui.base

sealed class Command {
    class ShowProgress : Command()
    class HideProgress : Command()
    class ShowVehicleDecodedInfo(val registrationNumber: String, val vin: String, val firstRegistrationDate: String) : Command()
    class NavigateToScannerView : Command()
    class NavigateToVehicleResultView(val registrationNumber: String, val vin: String, val firstRegistrationDate: String) : Command()
    class Error(val errorMessage: String ?) : Command()
}