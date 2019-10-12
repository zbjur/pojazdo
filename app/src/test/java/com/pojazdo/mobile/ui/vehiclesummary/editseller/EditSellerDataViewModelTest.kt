package com.pojazdo.mobile.ui.vehiclesummary.editseller

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.mobile.base.ApplicationScheduler
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.pojazdo.api.SellerDatafactory
import com.pojazdo.mobile.AndroidTestScheduler
import com.pojazdo.mobile.ui.Event
import com.pojazdo.mobile.ui.base.Command
import com.pojazdo.usecases.editspersoanlellerdata.EditPersonalSellerDataApi
import io.reactivex.Single
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class EditSellerDataViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val scheduler: ApplicationScheduler = AndroidTestScheduler()

    private val mockEditPersonalSellerDataApi: EditPersonalSellerDataApi = mock {
        on { editPersonalSellerData(any()) } doReturn (Single.just(SellerDatafactory.makeSeller()))
    }

    private var observer = mock<Observer<Event<Command>>>()

    private var systemUnderTest: EditSellerDataViewModel = EditSellerDataViewModel(scheduler, mockEditPersonalSellerDataApi)

    @Before
    fun setUp() {
        systemUnderTest.viewState.observeForever(observer)
    }

    @Test
    fun `update selle personal data`() {
        systemUnderTest?.updateSellePersonalData(SellerDatafactory.makeSeller())
        verify(observer).onChanged(any())
        assertNotNull(systemUnderTest.viewState.value)
    }
}