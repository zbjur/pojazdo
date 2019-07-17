package com.pojazdo.usecases.parser.model

import com.pojazdo.usecases.parser.maininfoparser.model.VehicleInfo
import com.pojazdo.usecases.parser.timelineparser.model.Timeline

data class VehicleReport(
        var vehicle: VehicleInfo?,
        var timeline: Timeline?)

