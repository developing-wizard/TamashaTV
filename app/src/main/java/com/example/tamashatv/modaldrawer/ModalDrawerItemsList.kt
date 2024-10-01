package com.example.tamashatv.modaldrawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import com.example.tamashatv.navigation.MainRouteScreen

val modalDrawerItemsList = listOf(
    ModalDrawerItem(
        title = "Profile",
        route = MainRouteScreen.Profile.route,
        selectedIcon = Icons.Filled.Person,
        unSelectedIcon = Icons.Outlined.Person,
    ),
    ModalDrawerItem(
        title = "Search",
        route = MainRouteScreen.Search.route,
        selectedIcon = Icons.Filled.Search,
        unSelectedIcon = Icons.Outlined.Search,
    ),
    ModalDrawerItem(
        title = "Home",
        route = MainRouteScreen.Home.route,
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home,
    ),
    ModalDrawerItem(
        title = "Movies",
        route = MainRouteScreen.Movies.route,
        selectedIcon = Icons.Filled.PlayArrow,
        unSelectedIcon = Icons.Outlined.PlayArrow,
    ),
    ModalDrawerItem(
        title = "Live Videos",
        route = MainRouteScreen.LiveVideos.route,
        selectedIcon = Icons.Filled.PlayArrow,
        unSelectedIcon = Icons.Outlined.PlayArrow,
    ),
    ModalDrawerItem(
        title = "Continue Watching",
        route = MainRouteScreen.AlreadyWatching.route,
        selectedIcon = Icons.Filled.Settings,
        unSelectedIcon = Icons.Outlined.Settings,
    ),
    ModalDrawerItem(
        title = "List Of Movies",
        route = MainRouteScreen.ListOfMovies.route,
        selectedIcon = Icons.Filled.Menu,
        unSelectedIcon = Icons.Outlined.Menu,
    ),
    ModalDrawerItem(
        title = "Settings",
        route = MainRouteScreen.Settings.route,
        selectedIcon = Icons.Filled.Settings,
        unSelectedIcon = Icons.Outlined.Settings,
    ),
)