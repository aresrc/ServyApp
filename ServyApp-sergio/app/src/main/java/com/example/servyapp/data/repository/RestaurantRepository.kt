package com.example.servyapp.data.repository

import com.example.servyapp.data.datasource.RestaurantRemoteDataSource
import com.example.servyapp.domain.model.Restaurant
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val restaurantRemoteDataSource: RestaurantRemoteDataSource
) {
     fun getRestaurants(): Flow<List<Restaurant>> {
        return restaurantRemoteDataSource.getRestaurants()
    }

    suspend fun getRestaurantById(id: String): Restaurant? =
        restaurantRemoteDataSource.getRestaurantById(id)

    //companion object
}