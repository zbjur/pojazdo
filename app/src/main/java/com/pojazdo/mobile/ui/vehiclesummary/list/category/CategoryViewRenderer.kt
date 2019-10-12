package com.pojazdo.mobile.ui.vehiclesummary.list.category

import android.view.ViewGroup
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer
import com.pojazdo.mobile.R

class CategoryViewRenderer: ViewRenderer<CategoryModel, CategoryViewHolder>(CategoryModel::class.java) {

    override fun bindView(model: CategoryModel, holder: CategoryViewHolder) {
        holder.mName.text = model.name
    }

    override fun createViewHolder(parent: ViewGroup?): CategoryViewHolder {

        return CategoryViewHolder(inflate(R.layout.item_category, parent))
    }

    interface Listener {
        fun onCategoryClicked(model: CategoryModel)
    }
}