package com.example.tamashatv.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.tv.material3.Icon
import androidx.tv.material3.Text
import com.example.tamashatv.R

@Composable
fun DashBoard() {
    var progress by remember { mutableStateOf(0.5f) }
    ConstraintLayout() {
        val (backgroundImage, scrimEffect, lblMovieName, lblMovieCategory, lblMovieYear, lblSeasonsNumber, lblSeasonEpisode, lblMovieDescription, lblMoviesStars, progressIndicator, lblWatchedDuration, btnResumePlaying, btnAddToMyList, btnMoreInfo, btnLike) = createRefs()
        Image(
            painter = painterResource(R.drawable.cover_image),
            contentDescription = "",
            modifier = Modifier
                .constrainAs(backgroundImage) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
                .fillMaxSize(),
            contentScale = ContentScale.FillBounds,
        )
        Box(
            modifier = Modifier
                .constrainAs(scrimEffect) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color.Black, Color.Transparent
                        )
                    )
                )
        )
        Text(
            modifier = Modifier.constrainAs(lblMovieName) {
                top.linkTo(parent.top, 15.dp)
                start.linkTo(parent.start, 15.dp)
            },
            text = "The Maze Runner",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.constrainAs(lblMovieCategory) {
                top.linkTo(lblMovieName.bottom, 7.dp)
                start.linkTo(lblMovieName.start)
            },
            text = "Tv Series",
            color = Color.Gray,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.constrainAs(lblMovieYear) {
                start.linkTo(lblMovieCategory.end, 10.dp)
                top.linkTo(lblMovieCategory.top)
            },
            text = "2023",
            color = Color.Gray,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.constrainAs(lblSeasonsNumber) {
                start.linkTo(lblMovieYear.end, 10.dp)
                top.linkTo(lblMovieYear.top)
            },
            text = "1 Season",
            color = Color.Gray,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.constrainAs(lblSeasonEpisode) {
                start.linkTo(lblSeasonsNumber.end, 10.dp)
                top.linkTo(lblSeasonsNumber.top)
            },
            text = "8 Episodes",
            color = Color.Gray,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier
                .constrainAs(lblMovieDescription) {
                    start.linkTo(lblMovieCategory.start)
                    top.linkTo(lblMovieCategory.bottom, 10.dp)

                }
                .fillMaxWidth(0.7f)
                .padding(0.dp, 8.dp, 8.dp, 8.dp),
            softWrap = true,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis,
            text = "The movie follows Lucy Carlyle, a gifted girl who has the ability to hear ghosts. After a tragic event in her past, she moves to London and joins Lockwood & Co., a small independent agency run by the enigmatic Anthony Lockwood, a charismatic and talented ghost hunter. Alongside Lockwood and his quirky but brilliant partner George Cubbins, Lucy begins her work of confronting powerful ghosts and investigating the mysteries that come with them.",
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Thin
        )
        Text(
            modifier = Modifier.constrainAs(lblMoviesStars) {
                start.linkTo(lblMovieDescription.start)
                top.linkTo(lblMovieDescription.bottom, 10.dp)
            },
            softWrap = true,
            text = "Stars",
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        LinearProgressIndicator(
            progress = {
                progress
            },
            modifier = Modifier
                .constrainAs(progressIndicator) {
                    top.linkTo(lblMoviesStars.bottom, margin = 10.dp)
                    start.linkTo(lblMoviesStars.start)
                }
                .fillMaxWidth(0.3f)
                .height(8.dp),
            color = Color.Blue,
            trackColor = Color.Gray,
        )
        Text(
            modifier = Modifier.constrainAs(lblWatchedDuration) {
                start.linkTo(progressIndicator.end, 10.dp)
                top.linkTo(lblMoviesStars.bottom, 10.dp)
            },
            softWrap = true,
            text = "21:34",
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Box(
            modifier = Modifier
                .constrainAs(btnResumePlaying) {
                    top.linkTo(progressIndicator.bottom, margin = 10.dp)
                    start.linkTo(progressIndicator.start)
                }
                .clip(RoundedCornerShape(12.dp))
                .background(Color.Blue)
        ) {
            TextButton(onClick = {
            }) {
                Text(
                    text = "Resume Playing",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }
        }
        Box(
            modifier = Modifier
                .constrainAs(btnAddToMyList) {
                    top.linkTo(btnResumePlaying.top)
                    start.linkTo(btnResumePlaying.end, 10.dp)
                }
                .clip(RoundedCornerShape(12.dp))
                .background(Color.Gray)
        ) {
            TextButton(onClick = {
            }) {
                Text(
                    text = "Add To My List",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }
        }
        Box(
            modifier = Modifier
                .constrainAs(btnMoreInfo) {
                    top.linkTo(btnAddToMyList.top)
                    start.linkTo(btnAddToMyList.end, 10.dp)
                }
                .clip(RoundedCornerShape(12.dp))
                .background(Color.Gray)
        ) {
            TextButton(onClick = {
            }) {
                Text(
                    text = "More Info",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }
        }
        Box(
            modifier = Modifier
                .constrainAs(btnLike) {
                    top.linkTo(btnMoreInfo.top)
                    start.linkTo(btnMoreInfo.end, 10.dp)
                }
                .clip(RoundedCornerShape(12.dp))
                .background(Color.Gray)
        ) {
//            IconButton(onClick = { /* Handle button click */ }) {
//                Icon(
//                    painter = painterResource(id = R.drawable.your_image), // Replace with your image resource
//                    contentDescription = "Button Image",
//                    modifier = Modifier.size(48.dp) // Set the size of the icon
//                )
//            }
        }
    }
}

//
//@Preview(
//    name = "Android TV Preview",
//    showSystemUi = true,
//    device = "spec:parent=tv_4k,orientation=landscape"
//)
//@Composable
//fun GreetingPreview() {
//    HomeScreen()
//}