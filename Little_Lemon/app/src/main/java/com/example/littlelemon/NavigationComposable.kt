package com.example.littlelemon

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = Home.route){
        composable(Home.route){
            Home(navController = navController)
        }
        composable(Onboarding.route){
            Onboarding(navController = navController)
        }
        composable(Profile.route){
            Profile()
        }
    }
}