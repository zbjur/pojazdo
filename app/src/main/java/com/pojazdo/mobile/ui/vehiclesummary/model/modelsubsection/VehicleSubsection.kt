package com.pojazdo.mobile.ui.vehiclesummary.model.modelsubsection

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
open class VehicleSubsection(val subsection: @RawValue SubSectionType) : Parcelable, SubSectionType {
    override fun checkVehicleSubSectionType() = subsection.checkVehicleSubSectionType()
}
