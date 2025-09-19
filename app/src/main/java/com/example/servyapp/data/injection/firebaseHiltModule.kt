package com.example.servyapp.data.injection

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class firebaseHiltModule {

    @Provides
    fun auth(): FirebaseAuth =FirebaseAuth.getInstance()

    @Provides
    fun firestore(): FirebaseFirestore = FirebaseFirestore.getInstance()

}