package com.pojazdo.api.database.vehicleadditionalinformation

import com.pojazdo.api.database.vehicleadditionalinformation.database.SellerDAO
import com.pojazdo.api.database.vehicleadditionalinformation.database.VehicleInformationDAO
import com.pojazdo.api.database.vehicleadditionalinformation.model.Seller
import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAdditionalInformation
import com.pojazdo.api.database.vehicleadditionalinformation.model.VehicleAndSellerInformation
import io.reactivex.Single
import javax.inject.Inject

class DatabasePersistenceSource @Inject constructor(private val vehicleInformationDAO: VehicleInformationDAO,
                                                    private val sellerDao: SellerDAO) : DatabasePersistenceApi {

    override fun getVehicleAdditionalInformation(vin: String): Single<VehicleAndSellerInformation> {
        return vehicleInformationDAO.loadVehiclesInfo(vin)
    }

    override fun persistVehicleAdditionalInformation(vehicleAdditionalInformation: VehicleAdditionalInformation) {
        vehicleInformationDAO.insertOrUpdate(vehicleAdditionalInformation)
    }

    override fun updateVehicleAdditionalInformation(vehicleAdditionalInformation: VehicleAdditionalInformation) {
        vehicleInformationDAO.update(vehicleAdditionalInformation)
    }

    override fun getAllVehicleAdditionalInformation(): Single<List<VehicleAndSellerInformation>> {
        return vehicleInformationDAO.loadAllVehiclesInfo()
    }

    override fun removeVehicleAdditionalInformation(vin: String) {
        return vehicleInformationDAO.delete(vin)
    }

    override fun persistSeller(seller: Seller) {
        return sellerDao.insertSeller(seller)
    }

    override fun updateSeller(seller: Seller) {
     sellerDao.updateSeller(seller)
    }

    override fun getSeller(id: Int): Single<Seller> {
        return  sellerDao.getSeller(id)
    }
}