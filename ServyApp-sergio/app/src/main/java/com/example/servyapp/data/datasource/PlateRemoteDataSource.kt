package com.example.servyapp.data.datasource

import com.example.servyapp.domain.model.Plate
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


class PlateRemoteDataSource @Inject constructor(
    private val firestore: FirebaseFirestore
) {

    suspend fun getPlatesByRestaurant(restaurantId: String): Result<List<Plate>> {
        return try {
            val plates = firestore.collection("restaurants")
                .document(restaurantId)
                .collection("plates")
                .get()
                .await()
                .toObjects(Plate::class.java)
            Result.success(plates)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getPlateById(restaurantId: String, plateId: String): Result<Plate?> {
        return try {
            val doc = firestore.collection("restaurants")
                .document(restaurantId)
                .collection("plates")
                .document(plateId)
                .get()
                .await()
            val plate = doc.toObject(Plate::class.java)?.copy(id = doc.id)
            Result.success(plate)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}