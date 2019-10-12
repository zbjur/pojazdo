package com.pojazdo.mobile.ui.vehiclesummary.list.list

import com.github.vivchar.rendererrecyclerviewadapter.CompositeViewHolder
import com.github.vivchar.rendererrecyclerviewadapter.CompositeViewState

import java.io.Serializable

/**
 * Created by Vivchar Vitaly on 21.10.17.
 */

class RecyclerViewState(holder: CompositeViewHolder) : CompositeViewState<RecyclerViewHolder>(holder), Serializable {

    override fun restore(holder: RecyclerViewHolder) {
        super.restore(holder)
    }
}
