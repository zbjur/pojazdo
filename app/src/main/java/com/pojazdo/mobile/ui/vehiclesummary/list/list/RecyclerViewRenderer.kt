package com.pojazdo.mobile.ui.vehiclesummary.list.list

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.vivchar.rendererrecyclerviewadapter.CompositeViewRenderer
import com.github.vivchar.rendererrecyclerviewadapter.RendererRecyclerViewAdapter
import com.github.vivchar.rendererrecyclerviewadapter.ViewState
import com.pojazdo.mobile.R
import com.pojazdo.mobile.ui.vehiclesummary.widgets.BetweenSpacesItemDecoration
import com.pojazdo.mobile.ui.vehiclesummary.widgets.NestedAdapter
import javax.inject.Inject

/**
 * Created by Vivchar Vitaly on 8/24/17.
 */

class RecyclerViewRenderer @Inject constructor() : CompositeViewRenderer<RecyclerViewModel, RecyclerViewHolder>(RecyclerViewModel::class.java) {

    override fun rebindView(model: RecyclerViewModel, holder: RecyclerViewHolder, payloads: List<Any>) {
        Log.d(TAG, "rebindView $model, payload: $payloads")
        holder.getAdapter().enableDiffUtil()
        holder.getAdapter().setItems(model.items)
    }

    override fun bindView(model: RecyclerViewModel, holder: RecyclerViewHolder) {
        Log.d(TAG, "bindView $model")
        holder.getAdapter().disableDiffUtil()
        holder.getAdapter().setItems(model.items)
        holder.getAdapter().notifyDataSetChanged()
    }

    public override fun createCompositeViewHolder(parent: ViewGroup?): RecyclerViewHolder {
        return RecyclerViewHolder(inflate(R.layout.item_composite, parent))
    }

    override fun createViewState(holder: RecyclerViewHolder): ViewState<*>? {
        return RecyclerViewState(holder)
    }

    override fun createViewStateID(model: RecyclerViewModel): Int {
        return model.id
    }

    override fun createAdapter(): RendererRecyclerViewAdapter {
        val nestedAdapter = NestedAdapter()
        //nestedAdapter.setDiffCallback(DefaultDiffCallback<BM>)
        return nestedAdapter
    }

    override fun createItemDecorations(): List<RecyclerView.ItemDecoration> {
        return listOf(BetweenSpacesItemDecoration(0, 10))
    }

    companion object {

        private val TAG = RecyclerViewRenderer::class.java.simpleName
    }
}
