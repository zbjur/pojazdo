package com.mirek.architecture.di.module

import com.mirek.architecture.ui.AndroidNavigator
import com.mirek.architecture.ui.application.Navigator
import com.mirek.api.network.htmlparser.VehicleHtmlParserBackendApi
import com.mirek.api.network.htmlparser.VehicleHtmlParserServiceFeed
import com.mirek.api.network.vehicledecoder.VehicleDecoderBackendApi
import com.mirek.api.network.vehicledecoder.VehicleDecoderServiceFeed
import com.mirek.api.network.vehicleinfo.VehicleInfoBackendApi
import com.mirek.api.network.vehicleinfo.VehicleInfoServiceFeed
import com.mirek.usecases.errorhandler.ErrorHandlerApi
import com.mirek.usecases.errorhandler.ErrorHandlerService
import com.mirek.usecases.vehicleaztecdecoder.VehicleDecoderApi
import com.mirek.usecases.vehicleaztecdecoder.VehicleDecoderService
import com.mirek.usecases.vehiclehtmlparser.VehicleHtmlParserApi
import com.mirek.usecases.vehiclehtmlparser.VehicleHtmlParserService
import com.mirek.usecases.vehicleinfo.VehicleInfoApi
import com.mirek.usecases.vehicleinfo.VehicleInfoService
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
    abstract fun bindsVehicleInfoApi(vehicleInfoService: VehicleInfoService): VehicleInfoApi

    @Binds
    @Singleton
    abstract fun bindsVehicleInfoBackendApi(vehicleInfoServiceFeed: VehicleInfoServiceFeed): VehicleInfoBackendApi

    @Binds
    @Singleton
    abstract fun bindsVehicleHtmlParserApi(vehicleInfoService: VehicleHtmlParserService): VehicleHtmlParserApi

    @Binds
    @Singleton
    abstract fun bindsVehicleHtmlParserBackendApi(vehicleHtmlParserServiceFeed: VehicleHtmlParserServiceFeed): VehicleHtmlParserBackendApi

    @Binds
    @Singleton
    abstract fun bindsErrorHandlerApi(errorHandlerService : ErrorHandlerService) : ErrorHandlerApi

    @Binds
    @Singleton
    abstract fun bindsNavigator(androidNavigator: AndroidNavigator): Navigator

}

