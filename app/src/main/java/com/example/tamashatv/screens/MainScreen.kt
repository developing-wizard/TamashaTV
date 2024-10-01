package com.example.tamashatv.screens

import ModalDrawerLayout
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tamashatv.modaldrawer.modalDrawerItemsList
import com.example.tamashatv.navigation.MainNavGraph
import kotlinx.coroutines.launch

@Composable
fun MainScreen(
    rootNavController: NavHostController = rememberNavController(),
    homeNavController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by homeNavController.currentBackStackEntryAsState()
    val currentRoute by remember(navBackStackEntry) {
        derivedStateOf {
            navBackStackEntry?.destination?.route
        }
    }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    BackHandler(enabled = drawerState.isOpen) {
        scope.launch { drawerState.close() }
    }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentWidth()
                    .clip(RoundedCornerShape(15.dp))
                    .background(Color.Transparent)
            ) {
                val (profileSection, drawerSetup, settingSection) = createRefs()


//                Box(
//                    modifier = Modifier
//                        .constrainAs(profileSection) {
//                            top.linkTo(parent.top)
//                            start.linkTo(parent.start)
//                            end.linkTo(parent.end)
//                        }
//                    // .fillMaxHeight(0.1F),
//
//                )
//                {
//                    Text("This Is Profile Section", color = Color.Black, fontSize = 16.sp)
//                }


                Box(
                    modifier = Modifier
                        .constrainAs(drawerSetup) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                        }.background(color = Color.Gray)
                        .onKeyEvent { keyEvent ->
                            if (keyEvent.key == Key.DirectionLeft) {
                                if (drawerState.isClosed)
                                    scope.launch {
                                        drawerState.open()
                                    } else
                                    scope.launch {
                                        drawerState.close()
                                    }
                                true
                            } else if (keyEvent.key == Key.DirectionRight && drawerState.isOpen) {
                                scope.launch {
                                    drawerState.close()
                                }
                                true
                            } else {
                                false
                            }
                        }
                        .background(color = Color.Transparent)
                        .fillMaxHeight()
                )
                {
                    ModalDrawerLayout(
                        items = modalDrawerItemsList,
                        currentRoute = currentRoute,
                        onClick = { item ->
                            scope.launch { drawerState.close() }
                            if (currentRoute != item.route) {
                                homeNavController.navigate(item.route) {
                                    launchSingleTop = true
                                }
                            }
                        }
                    )
                }

//
//                Box(
//                    modifier = Modifier
//                        .constrainAs(settingSection) {
//                            top.linkTo(drawerSetup.bottom)
//                            start.linkTo(parent.start)
//                            end.linkTo(parent.end)
//                        }
//                    // .fillMaxHeight(0.1F)
//                )
//                {
//                    Text("This Is Setting Section", color = Color.Black, fontSize = 16.sp)
//                }


            }

        },
        content = {
            Scaffold(
//                topBar = {
//                    IconButton(onClick = {
//
//                    }) {
//                        Icon(Icons.Default.Edit, contentDescription = "Open Drawer")
//                    }
//                },

                content = { innerPadding ->
                    MainNavGraph(rootNavController, homeNavController, innerPadding)
                }
            )
        }
    )
}


