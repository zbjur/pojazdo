package com.pojazdo.architecture.di.module

import com.pojazdo.architecture.ui.AndroidNavigator
import com.pojazdo.architecture.ui.application.Navigator
import com.pojazdo.api.network.vehiclehtmlparser.VehicleHtmlParserBackendApi
import com.pojazdo.api.network.vehiclehtmlparser.VehicleHtmlParserServiceFeed
import com.pojazdo.api.network.vehicledecoder.VehicleDecoderBackendApi
import com.pojazdo.api.network.vehicledecoder.VehicleDecoderServiceFeed
import com.pojazdo.api.network.vehicleinfo.VehicleInfoBackendApi
import com.pojazdo.api.network.vehicleinfo.VehicleInfoServiceFeed
import com.pojazdo.api.network.vehicleinformation.VehicleInforamtionBackendApi
import com.pojazdo.api.network.vehicleinformation.VehicleInformationServiceFeed
import com.pojazdo.api.network.vehiclerating.VehicleRatingBackendApi
import com.pojazdo.api.network.vehiclerating.VehicleRatingServiceFeed
import com.pojazdo.api.network.vehicletrader.VehicleTraderBackendApi
import com.pojazdo.api.network.vehicletrader.VehicleTraderServiceFeed
import com.pojazdo.usecases.errorhandler.ErrorHandlerApi
import com.pojazdo.usecases.errorhandler.ErrorHandlerService
import com.pojazdo.usecases.vehicleaztecdecoder.VehicleDecoderApi
import com.pojazdo.usecases.vehicleaztecdecoder.VehicleDecoderService
import com.pojazdo.usecases.vehiclehtmlparser.VehicleHtmlParserApi
import com.pojazdo.usecases.vehiclehtmlparser.VehicleHtmlParserService
import com.pojazdo.usecases.vehicleInformation.VehicleInformationApi
import com.pojazdo.usecases.vehicleInformation.VehicleInformationService
import com.pojazdo.usecases.vehiclerating.VehicleRatingApi
import com.pojazdo.usecases.vehiclerating.VehicleRatingService
import com.pojazdo.usecases.vehicletrader.VehicleTraderApi
import com.pojazdo.usecases.vehicletrader.VehicleTraderService
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ServiceModule{
    @Binds
    @Singleton
    abstract fun bindsVehicleDcoderApi(vehicleDecoderService: VehicleDecoderService): VehicleDecoderApi

    @Binds
    @Singleton
    abstract fun bindsVehicleDecoderBackendApi(vehicleDecoderServiceFeed: VehicleDecoderServiceFeed): VehicleDecoderBackendApi

    @Binds
    @Singleton
    abstract fun bindsVehicleInfoApi(vehicleInfoService: VehicleInformationService): VehicleInformationApi

    @Binds
    @Singleton
    abstract fun bindsVehicleInfoBackendApi(vehicleInfoServiceFeed: VehicleInfoServiceFeed): VehicleInfoBackendApi

    @Binds
    @Singleton
    abstract fun bindsVehicleInformationBackendApi(vehicleInformationServiceFeed: VehicleInformationServiceFeed): VehicleInforamtionBackendApi

    @Binds
    @Singleton
    abstract fun bindsVehicleRatingApi(vehicleRatingService: VehicleRatingService): VehicleRatingApi

    @Binds
    @Singleton
    abstract fun bindsVehicleRatingBackendApi(vehicleRatingServiceFeed: VehicleRatingServiceFeed): VehicleRatingBackendApi

    @Binds
    @Singleton
    abstract fun bindsVehicleHtmlParserApi(vehicleInfoService: VehicleHtmlParserService): VehicleHtmlParserApi

    @Binds
    @Singleton
    abstract fun bindsVehicleHtmlParserBackendApi(vehicleHtmlParserServiceFeed: VehicleHtmlParserServiceFeed): VehicleHtmlParserBackendApi

    @Binds
    @Singleton
    abstract fun bindsVehicleTraderApi(vehicleTraderService: VehicleTraderService): VehicleTraderApi

    @Binds
    @Singleton
    abstract fun bindsVehicleTraderBackendApi(VehicleTraderServiceFeed: VehicleTraderServiceFeed): VehicleTraderBackendApi

    @Binds
    @Singleton
    abstract fun bindsErrorHandlerApi(errorHandlerService : ErrorHandlerService) : ErrorHandlerApi

    @Binds
    @Singleton
    abstract fun bindsNavigator(androidNavigator: AndroidNavigator): Navigator

}