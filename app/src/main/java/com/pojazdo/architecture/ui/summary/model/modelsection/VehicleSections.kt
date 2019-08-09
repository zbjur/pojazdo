package com.pojazdo.architecture.ui.summary.model.modelsection

import com.pojazdo.architecture.ui.summary.model.modelsubsection.VehicleSubsection
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

abstract class VehicleSections(title: String = "", items: List<VehicleSubsection> = emptyList(), hasExpandableInitState: Boolean) : ExpandableGroup<VehicleSubsection>(title, items, hasExpandableInitState), SectionType