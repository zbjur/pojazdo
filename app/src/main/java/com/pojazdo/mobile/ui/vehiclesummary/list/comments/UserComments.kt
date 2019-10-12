package com.pojazdo.mobile.ui.vehiclesummary.list.rating

import com.github.vivchar.rendererrecyclerviewadapter.ViewModel

data class UserComments(val overallRating: String?,
                        val overallTitle: String?,
                        val buyAgainPercentage: String?,
                        val buyAgainTitle: String?) : ViewModel
