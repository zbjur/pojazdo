package com.pojazdo.mobile.ui.vehiclesummary.list.category

import android.view.ViewGroup
import com.github.vivchar.rendererrecyclerviewadapter.ViewRenderer
import com.pojazdo.mobile.R
import com.pojazdo.mobile.ui.vehiclesummary.list.navigation.INavigationDecorationFactory
import javax.inject.Inject

class FooterViewRenderer @Inject constructor(private val navigationDecorationFactory: INavigationDecorationFactory) : ViewRenderer<FooterModel, FooterViewHolder>(FooterModel::class.java) {

    override fun bindView(model: FooterModel, holder: FooterViewHolder) {
        holder.mName.text = model.name
        holder.footerContainer.setOnClickListener {
            navigationDecorationFactory.generateNavigationStrategy(model.navigationType).navigateToFragment(holder.footerContainer)
        }
    }

    override fun createViewHolder(parent: ViewGroup?): FooterViewHolder {
        return FooterViewHolder(inflate(R.layout.item_footer, parent))
    }

    interface Listener {
        fun onCategoryClicked(model: FooterModel)
    }
}