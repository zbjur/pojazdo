package com.pojazdo.architecture.ui.summary.list.holder

import android.text.SpannableStringBuilder
import android.view.View
import android.widget.TextView
import com.pojazdo.architecture.R
import com.pojazdo.architecture.ui.summary.model.Event
import com.pojazdo.architecture.ui.summary.model.VehicleTimeLine
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder

class VehicleTimeLineHolder(itemView: View) : ChildViewHolder(itemView) {

    private var eventDate: TextView? = null
    private var eventValue: TextView? = null

    init {
        eventDate = itemView.findViewById(R.id.event_date_text)
        eventValue = itemView.findViewById(R.id.event_value_text)
    }

    fun setTimeLine(timeLine: VehicleTimeLine) {
        val spannableStringBuilder = SpannableStringBuilder()
        spannableStringBuilder.append(timeLine.value)
        spannableStringBuilder.append("\n")
        buildEventText(timeLine, spannableStringBuilder)
        eventDate?.text = timeLine.date
        eventValue?.text = spannableStringBuilder.toString()
    }

    private fun buildEventText(timeLine: VehicleTimeLine, spannableStringBuilder: SpannableStringBuilder) {
        timeLine.events?.forEach {
            spannableStringBuilder.append(it.date.toUpperCase())
            spannableStringBuilder.append(" ")
            spannableStringBuilder.append(it.value)
            spannableStringBuilder.append("\n")
        }
    }
}