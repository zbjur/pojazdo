package com.pojazdo.mobile.ui.vehiclesummary.converter

import com.github.vivchar.rendererrecyclerviewadapter.ViewModel
import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAndSellerInformation
import com.pojazdo.api.network.vehicleinformation.model.*
import com.pojazdo.mobile.ui.vehiclesummary.list.avarageprices.VehicleAveragePriceSection
import com.pojazdo.mobile.ui.vehiclesummary.list.category.CategoryModel
import com.pojazdo.mobile.ui.vehiclesummary.list.category.FooterModel
import com.pojazdo.mobile.ui.vehiclesummary.list.list.RecyclerViewModel
import com.pojazdo.mobile.ui.vehiclesummary.list.map.VehicleMapSection
import com.pojazdo.mobile.ui.vehiclesummary.list.navigation.NavigationType
import com.pojazdo.mobile.ui.vehiclesummary.list.rating.VehicleOverallRatingSection
import com.pojazdo.mobile.ui.vehiclesummary.list.sellerdetails.VehiclePersonalDataSection
import com.pojazdo.mobile.ui.vehiclesummary.list.timeline.VehicleTimeLine
import com.pojazdo.mobile.ui.vehiclesummary.list.vehiclesummary.VehicleSummaryInfoModel
import com.pojazdo.mobile.ui.vehiclesummary.model.modelsubsection.*
import javax.inject.Inject

open class VehicleInformationConverter @Inject constructor() {

    fun convertToVehicleSectionList(vehicleInformation: VehicleInformation) = makeSections(vehicleInformation)

    private fun makeSections(vehicleInformation: VehicleInformation): MutableList<ViewModel> {
        val ratingList: MutableList<ViewModel> = mutableListOf()
        return ratingList.apply {
            add(makeVehicleSummaryInfoSubsection(vehicleInformation))
            add(FooterModel("Zobacz więcej", NavigationType.DETAILS))
            add(CategoryModel("Oś czasu"))
            addAll(makeVehicleHistorySubsection(vehicleInformation.timeLine))
            add(CategoryModel("Ocena"))
            add(makeVehicleOverallRatingSection(vehicleInformation.vehicleRating))
            add(FooterModel("Zobacz więcej", NavigationType.RATING))
            add(CategoryModel("Opinie uzytkowników"))
            addAll(makeUserCommentsSection(vehicleInformation.vehicleRating))
            add(FooterModel("Zobacz więcej", NavigationType.COMMENTS))
            add(CategoryModel("Szacunkowa wartość pojazdu"))
            add(makeVehiclePriceSection(vehicleInformation.vehicleAveragePrice))
            add(FooterModel(""))
            val offesStitle = "Przykładowe oferty"
            add(CategoryModel(offesStitle))
            val firstID = offesStitle.hashCode()
            add(RecyclerViewModel(firstID, makeVehicleAdsList(vehicleInformation.vehicleOffers)))
            add(FooterModel(""))
            add(CategoryModel("Dane do kontaktu"))
            add(makeVehiclePersonalDataSection(vehicleInformation))
            add(FooterModel("Zobacz więcej", NavigationType.CONTACT))
            add(CategoryModel("Lokalizacja"))
            add(makeVehicleMapSection(vehicleInformation.vehicleAndSellerInformation))
        }
        /* ratingList.addAll(makeVehicleHistorySubsection(vehicleInformation.timeLine))
         return ratingList*/
        /*return mutableListOf(
               makeVehicleSummaryInfoSubsection(vehicleInformation),*//*
               makeVehicleHistorySubsection(vehicleInformation.timeLine)
               makeVehicleOverallRatingSection(vehicleInformation.vehicleRating),
                makeVehiclePriceSection(vehicleInformation.vehicleAveragePrice),
                makeVehiclePersonalDataSection(vehicleInformation),
                makeVehicleMapSection(vehicleInformation.vehicleAndSellerInformation)*//*
                       )*/

        /*          ,
                  makeVehicleRatingSubsection(vehicleInformation.vehicleRating),
                  makeVehiclePriceSection(vehicleInformation.vehicleAveragePrice),
                  makeVehicleAdsSubsection(vehicleInformation.vehicleOfferSections),
                  makeVehiclePersonalDataSection(vehicleInformation),
                  makeVehicleMapSection(vehicleInformation.vehicleAndSellerInformation)*/
    }

    private fun makeUserCommentsSection(vehicleRating: VehicleRating?): MutableList<ViewModel> {
        val ratingList: MutableList<ViewModel> = mutableListOf()
        ratingList.apply {
            vehicleRating?.userRatings
                    ?.take(2)
                    ?.forEach {
                        ratingList.add(VehicleUserRatingSection(it.rating, it.user, it.model, it.type, it.comment))
                    }
        }
        return ratingList
    }

    private fun makeVehiclePersonalDataSection(vehicleInformation: VehicleInformation) =
            VehiclePersonalDataSection("Cieszyn", "Mennicza 4")

/*
    fun getVehiclePersonalDataSection(groupList: MutableList<VehicleSections>?, seller: Seller): MutableList<VehicleSections>? {
        val vehiclePersonalDataSection = VehiclePersonalDataSection(seller.city, seller.street)
        return groupList?.apply { set(5, vehiclePersonalDataSection) }
    }
*/


    private fun makeVehicleSummaryInfoSubsection(vehicleInformation: VehicleInformation) = VehicleSummaryInfoModel(
            vehicleInformation.brand,
            vehicleInformation.model,
            vehicleInformation.yearOfProduction,
            vehicleInformation.vin,
            vehicleInformation.engineCapacity,
            vehicleInformation.insurance,
            vehicleInformation.technicalExamination,
            vehicleInformation.lastMeterState,
            vehicleInformation.registrationState,
            vehicleInformation.engineCapacity,
            vehicleInformation.fuel,
            vehicleInformation.alternativeFuel)

    private fun makeVehicleDetailsSubsection(vehicleInformation: VehicleInformation?) = mutableListOf(
            VehicleSubsection(VehicleDetailsInfoSections(vehicleInformation?.brand, vehicleInformation?.model)))

    private fun makeVehicleHistorySubsection(timeLine: List<TimeLine>?) =
            mutableListOf<ViewModel>().apply {
                timeLine?.forEach {
                    add(VehicleTimeLine(it.date, it.description))
                }
            }

    private fun makeVehicleAdsList(vehicleOffersList: List<VehicleOffers>?) =
            mutableListOf<ViewModel>().apply {
                vehicleOffersList?.forEach {
                    add(VehicleOffersSection(it.brand, it.name, it.imgaeUrl, it.htmlUrl, "diesel", "30. 000"))
                }
            }


    private fun makeVehicleOverallRatingSection(vehicleRating: VehicleRating?) =
            VehicleOverallRatingSection(vehicleRating?.overallRating, vehicleRating?.overallTitle, vehicleRating?.buyAgainPercentage,
                    vehicleRating?.buyAgainTitle)


/*    private fun makeVehicleRatingSubsection(vehicleRating: VehicleRating?): MutableList<VehicleSubsection> {

        val ratingList: MutableList<VehicleSubsection> = mutableListOf()


        vehicleRating?.ratings?.forEach {
            ratingList.add(VehicleSubsection(VehicleRatingSubSection(it.title, it.rating)))
        }

        vehicleRating?.engineRating?.forEach {
            ratingList.add(VehicleSubsection(VehicleEngineRatingSubSection(it.engineName, it.rating, it.url)))
        }
        vehicleRating?.userRatings?.forEach {
            ratingList.add(VehicleSubsection(VehicleUserRatingSection(it.rating, it.user, it.model, it.type, it.comment)))
        }
        return ratingList
    }*/

    private fun makeVehiclePriceSection(vehicleAveragePrice: VehicleAveragePrice?) =
            VehicleAveragePriceSection(
                    vehicleAveragePrice?.minPrice,
                    vehicleAveragePrice?.maxPrice,
                    vehicleAveragePrice?.averagePrice)

    /*   private fun makeVehicleAdsSubsection(vehicleOfferList: List<VehicleOffers>?) = mutableListOf<VehicleSubsection>().apply {
           add(VehicleSubsection(VehicleAdSubSection(makeVehicleAdsList(vehicleOfferList))))
       }
   */

    private fun makeVehiclePersonalDataSubsection(vehicleAdditionalInformation: VehicleAndSellerInformation?) = VehiclePersonalDataSubSection("", "")


    private fun makeVehicleMapSection(vehicleAdditionalInformation: VehicleAndSellerInformation?) =
            VehicleMapSection(1.1,
                    1.1,
                    true)

}