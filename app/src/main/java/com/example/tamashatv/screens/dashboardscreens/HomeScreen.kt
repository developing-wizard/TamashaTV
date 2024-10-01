package com.example.tamashatv.screens.dashboardscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun HomeScreen(innerPadding: PaddingValues) {
    ConstraintLayout(modifier = Modifier.background(Color.White)
        .padding(innerPadding)
        .fillMaxSize()) {
        val box = createRef()
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.constrainAs(box){
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text("Home Screen")
        }
    }
}