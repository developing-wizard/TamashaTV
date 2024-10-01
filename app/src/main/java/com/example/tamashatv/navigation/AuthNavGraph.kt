package com.example.tamashatv.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.tamashatv.screens.authscreens.ForgotScreen
import com.example.tamashatv.screens.authscreens.IndexScreen
import com.example.tamashatv.screens.authscreens.LoginScreen

fun NavGraphBuilder.authNavGraph(rootNavController: NavHostController) {
    navigation(route = Graphs.AuthGraph, startDestination = AuthRouteScreen.Login.route) {
        composable(route = AuthRouteScreen.Login.route) {
            LoginScreen(rootNavController)
        }
        composable(route = AuthRouteScreen.Index.route) {
            IndexScreen(rootNavController)
        }
        composable(route = AuthRouteScreen.Forgot.route) {
            ForgotScreen(rootNavController)
        }
    }

}