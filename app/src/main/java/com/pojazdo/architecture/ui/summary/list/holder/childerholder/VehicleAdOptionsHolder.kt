package com.pojazdo.architecture.ui.summary.list.holder.childerholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pojazdo.architecture.R
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder

class VehicleAdOptionsHolder(itemView: View?) : ChildViewHolder(itemView) {


    var recycleView: RecyclerView? = null
    var valueTitle: TextView? = null

    init {
        recycleView = itemView?.findViewById(R.id.rv_child)
        valueTitle = itemView?.findViewById(R.id.textView)
    }
}