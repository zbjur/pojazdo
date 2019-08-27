package com.pojazdo.api.database.vehicleadditionalinformation

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import com.pojazdo.api.database.vehicleadditionalinformation.database.SellerDAO
import com.pojazdo.api.database.vehicleadditionalinformation.database.VehicleDatabase
import com.pojazdo.api.database.vehicleadditionalinformation.database.VehicleInformationDAO
import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAdditionalInformation
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class DatabasePersistenceSourceTest {

    private lateinit var systemUnderTest: DatabasePersistenceSource
    private lateinit var vehicleDatabase: VehicleDatabase
    private lateinit var vehicleInformationDAO: VehicleInformationDAO
    private lateinit var sellerDAO: SellerDAO

    @Before
    fun setUp() {
        val context = getInstrumentation().getTargetContext()
        vehicleDatabase = Room.inMemoryDatabaseBuilder(context, VehicleDatabase::class.java).build()
        vehicleInformationDAO = vehicleDatabase.vehicleInformationDao()
        systemUnderTest = DatabasePersistenceSource(vehicleInformationDAO, sellerDAO)
    }

    @After
    fun closeDb() {
        vehicleDatabase.close()
    }

    @Test
    fun getVehicleAdditionalInformation() {
        val vehicleAdditionalInformation = VehicleAdditionalInformation("1234", "", "", "", "2222", "", 12.00, "24242")
        systemUnderTest.persistVehicleAdditionalInformation(vehicleAdditionalInformation)
        /* val v = systemUnderTest.getAllVehicleAdditionalInformation()[0]
         Assertions.assertThat(v.vin).isEqualTo(vehicleAdditionalInformation.vin)*/

    }

    /*@Test
    fun persistVehicleAdditionalInformation() {
    }

    @Test
    fun updateVehicleAdditionalInformation() {
    }

    @Test
    fun getAllVehicleAdditionalInformation() {
    }

    @Test
    fun removeVehicleAdditionalInformation() {
    }*/
}