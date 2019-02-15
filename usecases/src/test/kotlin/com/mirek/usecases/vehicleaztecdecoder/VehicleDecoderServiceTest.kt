package com.mirek.usecases.vehicleaztecdecoder

import com.mirek.common.VehicleDataFactory
import com.mirek.api.network.vehicledecoder.VehicleDecoderBackendApi
import com.mirek.usecases.errorhandler.ErrorHandlerApi
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.Single
import org.junit.Test

class VehicleDecoderServiceTest {

    val vehicleDecoderBackendApi: VehicleDecoderBackendApi = mock {
        on { decodeAztecCode(any(), any(), any()) } doReturn Single.just(VehicleDataFactory.generateVehicleDecodedInfo())
    }

    val errorHandlerAPi: ErrorHandlerApi = mock()

    val systemUderTest = VehicleDecoderService(vehicleDecoderBackendApi, errorHandlerAPi)

    @Test
    fun `decode aztec code`() {
        val vehicleDecodedInfo = systemUderTest.decodeAztecCode("", "", " ").test()
        verify(vehicleDecoderBackendApi).decodeAztecCode("", "", "")
        vehicleDecodedInfo.assertComplete()
        vehicleDecodedInfo.assertNoErrors()
        vehicleDecodedInfo.assertValueCount(1)
    }
}