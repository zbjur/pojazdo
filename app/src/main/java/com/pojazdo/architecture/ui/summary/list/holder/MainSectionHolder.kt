package com.pojazdo.architecture.ui.summary.list.holder

import android.view.View
import android.view.animation.Animation.RELATIVE_TO_SELF
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView
import com.pojazdo.architecture.R
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder

class MainSectionHolder : GroupViewHolder {

    var genreName: TextView? = null
    var arrow: ImageView? = null
    var icon: ImageView? = null

    constructor(itemView: View) : super(itemView) {
        genreName = itemView?.findViewById(R.id.list_item_genre_name) as TextView
        arrow = itemView?.findViewById(R.id.list_item_genre_arrow) as ImageView
    }


    fun setText(title :String){
        genreName?.text = title
    }

    override fun expand() {
        animateExpand()
    }

    override fun collapse() {
        animateCollapse()
    }

    private fun animateExpand() {
        val rotate = RotateAnimation(360f, 180f, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f)
        rotate.duration = 300
        rotate.fillAfter = true
        arrow?.animation = rotate
    }

    private fun animateCollapse() {
        val rotate = RotateAnimation(180f, 360f, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f)
        rotate.duration = 300
        rotate.fillAfter = true
        arrow?.animation = rotate
    }
}