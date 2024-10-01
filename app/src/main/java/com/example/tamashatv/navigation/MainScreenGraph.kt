package com.example.tamashatv.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tamashatv.screens.dashboardscreens.AlreadyWatchingScreen
import com.example.tamashatv.screens.dashboardscreens.HomeScreen
import com.example.tamashatv.screens.dashboardscreens.ListOfMoviesScreen
import com.example.tamashatv.screens.dashboardscreens.LiveVideosScreen
import com.example.tamashatv.screens.dashboardscreens.MoviesScreen
import com.example.tamashatv.screens.dashboardscreens.ProfileScreen
import com.example.tamashatv.screens.dashboardscreens.SearchScreen
import com.example.tamashatv.screens.dashboardscreens.SettingsScreen


@Composable
fun MainNavGraph(
    rootNavController: NavHostController,
    homeNavController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = homeNavController,
        route = Graphs.MainScreenGraph,
        startDestination = MainRouteScreen.Home.route
    ) {
        composable(route = MainRouteScreen.Profile.route) {
            ProfileScreen(innerPadding = innerPadding)
        }
        composable(route = MainRouteScreen.Search.route) {
            SearchScreen(innerPadding = innerPadding)
        }
        composable(route = MainRouteScreen.Home.route) {
            HomeScreen(innerPadding = innerPadding)
        }
        composable(route = MainRouteScreen.Movies.route) {
            MoviesScreen(innerPadding = innerPadding)
        }
        composable(route = MainRouteScreen.LiveVideos.route) {
            LiveVideosScreen(innerPadding = innerPadding)
        }
        composable(route = MainRouteScreen.AlreadyWatching.route) {
            AlreadyWatchingScreen(innerPadding = innerPadding)
        }
        composable(route = MainRouteScreen.ListOfMovies.route) {
            ListOfMoviesScreen(innerPadding = innerPadding)
        }
        composable(route = MainRouteScreen.Settings.route) {
            SettingsScreen(innerPadding = innerPadding)
        }
    }
}