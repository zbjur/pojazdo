package com.pojazdo.architecture.ui.summary.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
open class VehicleSubsection(val subsection: @RawValue SectionType) : Parcelable, SectionType {
    override fun checkVehicleSectionType() = subsection.checkVehicleSectionType()
}
