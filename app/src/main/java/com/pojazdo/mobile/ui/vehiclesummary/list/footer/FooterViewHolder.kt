package com.pojazdo.mobile.ui.vehiclesummary.list.category

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.github.vivchar.rendererrecyclerviewadapter.ViewHolder
import com.pojazdo.mobile.R

/**
 * Created by Vivchar Vitaly on 1/10/17.
 */
class FooterViewHolder(itemView: View) : ViewHolder(itemView) {

    val mName: TextView = itemView.findViewById<View>(R.id.footerText) as TextView
    val footerContainer: ConstraintLayout = itemView.findViewById<View>(R.id.footer_container) as ConstraintLayout

}
