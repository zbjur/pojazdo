package com.pojazdo.api.network.vehicleinformation.model
import com.google.gson.annotations.SerializedName

data class Documents (

	@SerializedName("currentVehicleRegistrationCertificateIssueDate") val currentVehicleRegistrationCertificateIssueDate : String,
	@SerializedName("vehicleRecordDocumentIssuedDate") val vehicleRecordDocumentIssuedDate : String
)