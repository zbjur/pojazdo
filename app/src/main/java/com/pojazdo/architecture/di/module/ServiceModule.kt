package com.pojazdo.architecture.di.module

import com.pojazdo.api.database.vehicleadditionalinformation.DatabasePersistenceApi
import com.pojazdo.api.database.vehicleadditionalinformation.DatabasePersistenceSource
import com.pojazdo.api.network.vehiclehtmlparser.VehicleHtmlParserBackendApi
import com.pojazdo.api.network.vehiclehtmlparser.VehicleHtmlParserServiceFeed
import com.pojazdo.api.network.vehicleinformation.VehicleInformationBackendApi
import com.pojazdo.api.network.vehicleinformation.VehicleInformationServiceFeed
import com.pojazdo.architecture.ui.AndroidNavigator
import com.pojazdo.architecture.ui.application.Navigator
import com.pojazdo.usecases.editspersoanlellerdata.EditPersonalSellerDataApi
import com.pojazdo.usecases.editspersoanlellerdata.EditPersonalSellerDataService
import com.pojazdo.usecases.errorhandler.ErrorHandlerApi
import com.pojazdo.usecases.errorhandler.ErrorHandlerService
import com.pojazdo.usecases.vehicleInformation.VehicleInformationApi
import com.pojazdo.usecases.vehicleInformation.VehicleInformationService
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ServiceModule {

    @Binds
    @Singleton
    abstract fun bindsVehicleInfoApi(vehicleInfoService: VehicleInformationService): VehicleInformationApi

    @Binds
    @Singleton
    abstract fun bindsPersoanlDataSellerApi(editPersonalSellerDataService: EditPersonalSellerDataService): EditPersonalSellerDataApi

    @Binds
    @Singleton
    abstract fun bindsVehicleInformationBackendApi(vehicleInformationServiceFeed: VehicleInformationServiceFeed): VehicleInformationBackendApi

    @Binds
    @Singleton
    abstract fun bindsVehicleAdditionalInformationPersistenceApi(vehicleAdditionalInformationPersistenceSource: DatabasePersistenceSource): DatabasePersistenceApi

    @Binds
    @Singleton
    abstract fun bindsVehicleHtmlParserBackendApi(vehicleHtmlParserServiceFeed: VehicleHtmlParserServiceFeed): VehicleHtmlParserBackendApi

    @Binds
    @Singleton
    abstract fun bindsErrorHandlerApi(errorHandlerService: ErrorHandlerService): ErrorHandlerApi

    @Binds
    @Singleton
    abstract fun bindsNavigator(androidNavigator: AndroidNavigator): Navigator

}