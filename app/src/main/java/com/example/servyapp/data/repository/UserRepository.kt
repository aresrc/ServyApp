package com.example.servyapp.data.repository

import com.example.servyapp.data.datasource.AuthRemoteDataSource
import com.example.servyapp.data.datasource.UserRemoteDataSource
import com.example.servyapp.domain.model.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) {
    suspend fun createUserProfile(user: User) =
        userRemoteDataSource.createUserProfile(user)

    suspend fun updateUserProfile(user: User) =
        userRemoteDataSource.updateUserProfile(user)

    suspend fun getUserProfile(uid: String): User? =
        userRemoteDataSource.getUserProfile(uid)
}