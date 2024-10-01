package com.example.tamashatv.modaldrawer

import androidx.compose.ui.graphics.vector.ImageVector


data class ModalDrawerItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
)
