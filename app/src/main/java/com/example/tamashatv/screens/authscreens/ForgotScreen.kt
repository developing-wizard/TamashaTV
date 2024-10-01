package com.example.tamashatv.screens.authscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.tamashatv.navigation.AuthRouteScreen
import com.example.tamashatv.navigation.Graphs

@Composable
fun ForgotScreen(navController: NavController) {
    ConstraintLayout(modifier = Modifier.background(Color.White)) {

        Box(
            contentAlignment = Alignment.Center,
//            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                onClick = {
                    navController.navigate(Graphs.MainScreenGraph) {
                        popUpTo(AuthRouteScreen.Login.route) {
                            inclusive = true
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF8C1A0B), contentColor = Color.White
                ),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text(text = "Move To Dashboard")

            }
        }
    }
}