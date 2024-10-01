package com.example.tamashatv.navigation

object Graphs{
    const val RootGraph = "root_graph"
    const val AuthGraph = "auth_graph"
    const val MainScreenGraph = "main_screen_graph"
}

sealed class AuthRouteScreen(val route : String ){
    object Login : AuthRouteScreen("login")
    object Index : AuthRouteScreen("index")
    object Forgot : AuthRouteScreen("forgot")
}
sealed class MainRouteScreen(val route : String ){
    object Profile : MainRouteScreen("profile")
    object Search : MainRouteScreen("search")
    object Home : MainRouteScreen("home")
    object Movies : MainRouteScreen("movies")
    object LiveVideos : MainRouteScreen("live_videos")
    object  AlreadyWatching: MainRouteScreen("already_watching")
    object  ListOfMovies: MainRouteScreen("list_of_movies")
    object  Settings: MainRouteScreen("settings")
}
