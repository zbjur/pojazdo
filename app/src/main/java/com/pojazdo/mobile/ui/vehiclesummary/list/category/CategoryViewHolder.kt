package com.pojazdo.mobile.ui.vehiclesummary.list.category

import android.view.View
import android.widget.TextView
import com.github.vivchar.rendererrecyclerviewadapter.ViewHolder
import com.pojazdo.mobile.R

/**
 * Created by Vivchar Vitaly on 1/10/17.
 */
class CategoryViewHolder(itemView: View) : ViewHolder(itemView) {

    val mName: TextView = itemView.findViewById<View>(R.id.title) as TextView

}
