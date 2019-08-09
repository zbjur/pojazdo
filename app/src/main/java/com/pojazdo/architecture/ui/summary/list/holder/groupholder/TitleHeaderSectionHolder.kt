package com.pojazdo.architecture.ui.summary.list.holder.groupholder

import android.view.View
import android.view.animation.Animation.RELATIVE_TO_SELF
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView
import com.pojazdo.architecture.R
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder

class TitleHeaderSectionHolder : GroupViewHolder {

    var genreName: TextView? = null
    var arrow: ImageView? = null
    var icon: ImageView? = null

    constructor(itemView: View) : super(itemView) {
        genreName = itemView?.findViewById(R.id.list_item_section_name) as TextView
        arrow = itemView?.findViewById(R.id.list_item_section_arrow) as ImageView
    }


    fun setGroupTitle(title :String){
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