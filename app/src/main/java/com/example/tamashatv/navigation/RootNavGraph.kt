package com.example.tamashatv.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tamashatv.screens.MainScreen

@Composable
fun RootNavGraph() {
    val rootNavController = rememberNavController()
    NavHost(
        navController = rootNavController,
        route = Graphs.RootGraph,
        startDestination = Graphs.AuthGraph
    ) {
        authNavGraph(rootNavController)
        composable(route = Graphs.MainScreenGraph){
            MainScreen(rootNavController)
        }

    }
}