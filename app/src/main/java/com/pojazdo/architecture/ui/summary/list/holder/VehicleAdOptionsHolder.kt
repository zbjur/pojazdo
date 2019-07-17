package com.pojazdo.architecture.ui.summary.list.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.pojazdo.architecture.R
import com.pojazdo.architecture.ui.summary.model.VehicleAdSection
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder

class VehicleAdOptionsHolder(itemView: View?) : ChildViewHolder(itemView) {


    var recycleView: RecyclerView? = null
     var valueTitle: TextView? = null

    init {
        recycleView =  itemView?.findViewById(R.id.rv_child)
        valueTitle = itemView?.findViewById(R.id.textView)
    }
}