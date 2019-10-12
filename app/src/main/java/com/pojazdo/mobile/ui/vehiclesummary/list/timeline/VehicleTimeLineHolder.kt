package com.pojazdo.mobile.ui.vehiclesummary.list.timeline

import android.text.SpannableStringBuilder
import android.view.View
import android.widget.TextView
import com.github.vivchar.rendererrecyclerviewadapter.ViewHolder
import com.pojazdo.api.network.vehicleinformation.model.Description
import com.pojazdo.mobile.R
import com.pojazdo.mobile.ui.vehiclesummary.view.PojazdoTimeLineCircleView
import com.pojazdo.mobile.ui.vehiclesummary.view.TimeLineEventState

class VehicleTimeLineHolder(itemView: View) : ViewHolder(itemView) {

    private var eventDate: TextView? = null
    private var eventValue: TextView? = null
    private var pojazdoTimeLineCircleView: PojazdoTimeLineCircleView? = null

    private val timeLineEventState: TimeLineEventState = TimeLineEventState()

    init {
        eventDate = itemView.findViewById(R.id.event_date_text)
        eventValue = itemView.findViewById(R.id.event_value_text)
    //   pojazdoTimeLineCircleView = itemView.findViewById(R.id.timeLineCircleView)
    }

    fun setTimeLine(timeLine: VehicleTimeLine) {
        val spannableStringBuilder = SpannableStringBuilder()
        buildEventText(timeLine.descriptions, spannableStringBuilder)
        eventDate?.text = timeLine.date
        eventValue?.text = spannableStringBuilder.toString()
       // pojazdoTimeLineCircleView?.setTimeLineCircleBackground(timeLineEventState.getTimeLineCircleState(1))
    }

    private fun buildEventText(descriptions: List<Description>?, spannableStringBuilder: SpannableStringBuilder) {
        descriptions?.forEach {
            spannableStringBuilder.append(it.description)
            spannableStringBuilder.append("\n")
        }
    }
}