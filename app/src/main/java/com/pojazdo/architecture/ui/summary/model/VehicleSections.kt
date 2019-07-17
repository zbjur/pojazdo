package com.pojazdo.architecture.ui.summary.model

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

class VehicleSections(title: String?, items: List<VehicleSubsection>?) : ExpandableGroup<VehicleSubsection>(title, items)