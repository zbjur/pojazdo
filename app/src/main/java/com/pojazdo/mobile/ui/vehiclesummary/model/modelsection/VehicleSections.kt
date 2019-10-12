package com.pojazdo.mobile.ui.vehiclesummary.model.modelsection

import com.pojazdo.mobile.ui.vehiclesummary.model.modelsubsection.VehicleSubsection
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

abstract class VehicleSections(title: String = "", items: List<VehicleSubsection> = emptyList(), hasExpandableInitState: Boolean) : ExpandableGroup<VehicleSubsection>(title, items, hasExpandableInitState), SectionType