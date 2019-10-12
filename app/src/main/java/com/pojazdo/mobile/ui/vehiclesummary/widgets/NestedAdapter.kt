package com.pojazdo.mobile.ui.vehiclesummary.widgets

import android.util.Log
import android.view.ViewGroup

import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter
import com.github.vivchar.rendererrecyclerviewadapter.ViewHolder

/**
 * Created by Vivchar Vitaly on 21.10.17.
 */

class NestedAdapter : RendererRecyclerViewAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, typeIndex: Int): ViewHolder {
        val viewHolder = super.onCreateViewHolder(parent, typeIndex)
        Log.d(TAG, "onCreateViewHolder: " + viewHolder.javaClass.simpleName)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: List<*>?) {
        Log.d(TAG, "onBindViewHolder: " + holder.javaClass.simpleName)
        super.onBindViewHolder(holder, position, payloads)
    }

    override fun onViewRecycled(holder: ViewHolder) {
        Log.d(TAG, "onViewRecycled: " + holder.javaClass.simpleName)
        super.onViewRecycled(holder)
    }

    companion object {

        private val TAG = NestedAdapter::class.java.simpleName
    }
}