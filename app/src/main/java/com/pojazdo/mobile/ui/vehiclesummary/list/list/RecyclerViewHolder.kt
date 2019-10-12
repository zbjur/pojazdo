package com.pojazdo.mobile.ui.vehiclesummary.list.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.github.vivchar.rendererrecyclerviewadapter.CompositeViewHolder
import com.pojazdo.mobile.R


/**
 * Created by Vivchar Vitaly on 8/24/17.
 */

class RecyclerViewHolder(view: View) : CompositeViewHolder(view) {

    init {
        recyclerView = view.findViewById<View>(R.id.recycler_view) as RecyclerView
    }
}