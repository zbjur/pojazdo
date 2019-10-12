package com.pojazdo.mobile.ui.vehiclesummary.list.list

import com.github.vivchar.rendererrecyclerviewadapter.CompositeViewModel
import com.github.vivchar.rendererrecyclerviewadapter.DefaultCompositeViewModel
import com.github.vivchar.rendererrecyclerviewadapter.ViewModel

/**
 * Created by Vivchar Vitaly on 8/24/17.
 */

class RecyclerViewModel(val id: Int, items: MutableList<ViewModel>) : DefaultCompositeViewModel(items) {

    override fun equals(o: Any?): Boolean {
        return o is CompositeViewModel && mItems == o.items
    }

    override fun hashCode(): Int {
        return id
    }

    override fun toString(): String {
        //		return getClass().getSimpleName() + "{" + mID + ", " + mType + ", " + mItems.toString() + "}";
        return javaClass.simpleName + "{" + mItems.toString() + "}"
    }
}