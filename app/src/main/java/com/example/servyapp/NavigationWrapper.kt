package com.example.servyapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.servyapp.presentation.initial.InitialScreen
import com.example.servyapp.presentation.login.LoginScreen
import com.example.servyapp.presentation.signup.SignUpScreen

@Composable
fun NavigationWrapper(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "initial") {
        composable("initial") {
            InitialScreen(navController = navHostController)
        }
        composable("loginScreen") {
            LoginScreen(navController = navHostController)
        }
        composable("signUpScreen") {
            SignUpScreen(navController = navHostController)
        }
    }
}