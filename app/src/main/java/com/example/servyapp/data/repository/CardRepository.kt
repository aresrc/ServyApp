package com.example.servyapp.data.repository

import com.example.servyapp.data.datasource.AuthRemoteDataSource
import com.example.servyapp.data.datasource.UserRemoteDataSource
import javax.inject.Inject

class CardRepository @Inject constructor( //para agregar, actualizar o eliminar tarjetas
    //private val authRemoteDataSource: AuthRemoteDataSource,
    //private val userRemoteDataSource: UserRemoteDataSource
) {

//    private val tarjetasRef = db.getReference("tarjetas")
//
//    suspend fun addOrUpdateCard(uid: String, card: CreditCard) {
//        tarjetasRef.child(uid).setValue(card).await()
//    }
//
//    suspend fun getCard(uid: String): CreditCard? {
//        val snapshot = tarjetasRef.child(uid).get().await()
//        return snapshot.getValue(CreditCard::class.java)
//    }
//
//    suspend fun deleteCard(uid: String) {
//        tarjetasRef.child(uid).removeValue().await()
//    }
}