package com.example.servyapp.data.repository

import com.example.servyapp.data.datasource.PlateRemoteDataSource
import com.example.servyapp.domain.model.Plate
import javax.inject.Inject

class PlateRepository @Inject constructor(
    private val plateRemoteDataSource: PlateRemoteDataSource
) {
    suspend fun getPlatesByRestaurant(restaurantId: String): Result<List<Plate>> {
        return plateRemoteDataSource.getPlatesByRestaurant(restaurantId)
    }

    suspend fun getPlateById(restaurantId: String, plateId: String): Result<Plate?> {
        return plateRemoteDataSource.getPlateById(restaurantId, plateId)
    }
}