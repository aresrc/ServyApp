package com.example.servyapp.domain.useCase

import com.example.servyapp.data.repository.AuthRepository
import com.example.servyapp.data.repository.UserRepository
import com.example.servyapp.domain.model.User
import kotlinx.coroutines.delay
import javax.inject.Inject

class SignupUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) {
    suspend fun execute(email: String, password: String, phone: String): Result<Unit> {
        return try {
            authRepository.signUp(email, password)
            val uid = authRepository.currentUser?.uid ?: throw Exception("No se pudo obtener UID")

            val user = User(uid, phone, email)
            userRepository.createUserProfile(user)

            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}