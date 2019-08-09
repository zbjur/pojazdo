package com.pojazdo.architecture.ui.summary.list.holder.childerholder

import android.text.SpannableStringBuilder
import android.view.View
import android.widget.TextView
import com.pojazdo.api.network.vehicleinformation.model.Description
import com.pojazdo.architecture.R
import com.pojazdo.architecture.ui.summary.model.modelsubsection.VehicleTimeLine
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
        buildEventText(timeLine.descriptions, spannableStringBuilder)
        eventDate?.text = timeLine.date
        eventValue?.text = spannableStringBuilder.toString()
    }

    private fun buildEventText(descriptions: List<Description>?, spannableStringBuilder: SpannableStringBuilder) {
        descriptions?.forEach {
            spannableStringBuilder.append(it.description)
            spannableStringBuilder.append("\n")
        }
    }
}