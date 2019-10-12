package com.pojazdo.mobile.ui.vehiclesummary.model.modelsubsection

import com.github.vivchar.rendererrecyclerviewadapter.ViewModel

data class VehicleUserRatingSection(val rating: String,
                                    val user: String,
                                    val model: String,
                                    val type: String,
                                    val comment: String) : ViewModel
