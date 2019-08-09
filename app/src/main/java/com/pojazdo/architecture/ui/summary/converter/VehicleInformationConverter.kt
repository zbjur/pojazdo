package com.pojazdo.architecture.ui.summary.converter

import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAdditionalInformation
import com.pojazdo.api.network.vehicleinformation.model.*
import com.pojazdo.architecture.ui.summary.model.modelsection.*
import com.pojazdo.architecture.ui.summary.model.modelsubsection.*
import javax.inject.Inject

open class VehicleInformationConverter @Inject constructor() {

    fun convertToVehicleSectionList(vehicleInformation: VehicleInformation) = makeSections(vehicleInformation)

    private fun makeSections(vehicleInformation: VehicleInformation): MutableList<VehicleSections> {
        return mutableListOf(
                makeVehicleMainInfoSubsection(vehicleInformation),
                VehicleTitleSection("Historia Pojazdu ", makeVehicleHistorySubsection(vehicleInformation.timeLine), true),
                VehicleTitleSection("Komentarze Użytkowników", makeVehicleRatingSubsection(vehicleInformation.vehicleRating), false),
                VehicleTitleSection("Wartość Pojazdu", makeVehiclePriceSubsection(vehicleInformation.vehicleAveragePrice), false),
                VehicleTitleSection("Podobne poazdy", makeVehicleAdsSubsection(vehicleInformation.vehicleOffers), true),
                // makeVehiclePersonalDataSubsection(vehicleInformation.vehicleAdditionalInformation),
                makeVehiclePersonalDataSection(vehicleInformation),
                makeVehicleMapSection(vehicleInformation.vehicleAdditionalInformation)
        )
    }

    private fun makeVehiclePersonalDataSection(vehicleInformation: VehicleInformation) =
            VehiclePersonalDataSection("", "", makeVehiclePersonalDataSubsection(vehicleInformation.vehicleAdditionalInformation), false)

    private fun makeVehicleMainInfoSubsection(vehicleInformation: VehicleInformation) = VehicleMainInfoSections(
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
            vehicleInformation.alternativeFuel,
            true)

    private fun makeVehicleHistorySubsection(timeLine: List<TimeLine>?) =
            mutableListOf<VehicleSubsection>().apply {
                timeLine?.forEach {
                    add(VehicleSubsection(VehicleTimeLine(it.date, it.description)))
                }
            }

    private fun makeVehicleRatingSubsection(vehicleRating: VehicleRating?): MutableList<VehicleSubsection> {

        val ratingList: MutableList<VehicleSubsection> = mutableListOf()

        ratingList.add(VehicleSubsection(VehicleOverallRatingSubSection(vehicleRating?.overallRating, vehicleRating?.overallTitle, vehicleRating?.buyAgainPercentage, vehicleRating?.buyAgainTitle)))

        vehicleRating?.ratings?.forEach {
            ratingList.add(VehicleSubsection(VehicleRatingSubSection(it.title, it.rating)))
        }

        vehicleRating?.engineRating?.forEach {
            ratingList.add(VehicleSubsection(VehicleEngineRatingSubSection(it.engineName, it.rating, it.url)))
        }
        vehicleRating?.userRatings?.forEach {
            ratingList.add(VehicleSubsection(VehicleUserRatingSubSection(it.rating, it.user, it.model, it.type, it.comment)))
        }
        return ratingList
    }

    private fun makeVehiclePriceSubsection(vehicleAveragePrice: VehicleAveragePrice?) = mutableListOf(
            VehicleSubsection(VehiclePriceSubSection(
                    vehicleAveragePrice?.minPrice,
                    vehicleAveragePrice?.maxPrice,
                    vehicleAveragePrice?.averagePrice)))

    private fun makeVehicleAdsSubsection(vehicleOfferList: List<VehicleOffers>?) = mutableListOf<VehicleSubsection>().apply {
        add(VehicleSubsection(VehicleAdSubSection(makeVehicleAdsList(vehicleOfferList))))
    }

    private fun makeVehicleAdsList(vehicleOffersList: List<VehicleOffers>?) = mutableListOf<VehicleAd>().apply {
        vehicleOffersList?.forEach {
            add(VehicleAd(it.brand, it.name, it.imgaeUrl, it.htmlUrl, it.vehicleConfiguration, it.price))
        }
    }

    private fun makeVehiclePersonalDataSubsection(vehicleAdditionalInformation: VehicleAdditionalInformation?) = mutableListOf(
            VehicleSubsection(VehiclePersonalDataSubSection(
                    vehicleAdditionalInformation?.email,
                    vehicleAdditionalInformation?.phoneNumber)))


    private fun makeVehicleMapSection(vehicleAdditionalInformation: VehicleAdditionalInformation?) =
            VehicleMapSection(
                    vehicleAdditionalInformation?.latitiude,
                    vehicleAdditionalInformation?.latitiude,
                    true)

}