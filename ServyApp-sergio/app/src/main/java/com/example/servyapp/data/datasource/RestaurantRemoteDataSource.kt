package com.example.servyapp.data.datasource
import android.system.Os.close
import android.util.Log

import com.example.servyapp.domain.model.Restaurant
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose

import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class RestaurantRemoteDataSource  @Inject constructor(
    private val firestore: FirebaseFirestore
    ) {
    fun getRestaurants(): Flow<List<Restaurant>> = callbackFlow {
        val subscription = firestore.collection("restaurants")
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    close(error)
                    return@addSnapshotListener
                }

                if (snapshot != null) {
                    val restaurants = snapshot.documents.mapNotNull { doc ->
                        doc.toObject(Restaurant::class.java)?.copy(id = doc.id)
                    }

                    Log.d("Firestore", "Datos recibidos: $restaurants") // ✅ DEBUG
                    trySend(restaurants).isSuccess
                }
            }

        awaitClose { subscription.remove() }
    }

        suspend fun getRestaurantById(id: String): Restaurant? {
            return try {
                firestore.collection("restaurants")
                    .document(id)
                    .get()
                    .await()
                    .toObject(Restaurant::class.java)
            } catch (e: Exception) {
                null
            }
        }
    }
