package com.pojazdo.architecture.ui.summary.model.modelsubsection

import android.os.Parcelable
import com.pojazdo.architecture.ui.summary.model.modelsubsection.SubSectionType
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
open class VehicleSubsection(val subsection: @RawValue SubSectionType) : Parcelable, SubSectionType {
    override fun checkVehicleSubSectionType() = subsection.checkVehicleSubSectionType()
}
