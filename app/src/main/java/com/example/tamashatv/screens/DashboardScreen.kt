import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.tamashatv.R
@Preview( widthDp = 1080,
    heightDp = 720,
    showBackground = true,
    backgroundColor = 0x000000)
@Composable
fun DashboardScreen() {
    val scrollState = rememberScrollState()
    ConstraintLayout(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.Black).verticalScroll(scrollState)
    ) {
        val (mainColumn, recyclerContinueWatching, recyclerLastWatch, recyclerPopularMovies, txtContinueWatching, txtLastWatch, txtPopularMovies) = createRefs()
//        LazyColumn(modifier = Modifier.constrainAs(mainColumn){
//            top.linkTo(parent.top)
//            start.linkTo(parent.start)
//            end.linkTo(parent.end)
//            bottom.linkTo(parent.bottom)
//        }) {
        Text(
            text = "Continue Watching",
            color = Color.White,
            fontSize = 26.sp,
            modifier = Modifier.constrainAs(txtContinueWatching) {
                top.linkTo(parent.top, 10.dp)
                start.linkTo(parent.start, 25.dp)
            })
        LazyRow(
            modifier = Modifier
                .constrainAs(recyclerContinueWatching) {
                    top.linkTo(txtContinueWatching.bottom, 15.dp)
                    start.linkTo(txtContinueWatching.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .background(Color.Transparent),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(getContinueWatchingListData()) { item ->
                RecyclerLayout(item)
            }
        }
        Text(
            text = "Last Watch",
            color = Color.White,
            fontSize = 26.sp,
            modifier = Modifier.constrainAs(txtLastWatch) {
                top.linkTo(recyclerContinueWatching.bottom, 25.dp)
                start.linkTo(recyclerContinueWatching.start)
            })
        LazyRow(
            modifier = Modifier
                .constrainAs(recyclerLastWatch) {
                    top.linkTo(txtLastWatch.bottom, 15.dp)
                    start.linkTo(txtLastWatch.start)
                }
                .fillMaxWidth()
                .background(Color.Transparent),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(getLastWatchListData()) { item ->
                RecyclerLayout(item)
            }
        }
        Text(
            text = "Popular Movies",
            color = Color.White,
            fontSize = 26.sp,
            modifier = Modifier.constrainAs(txtPopularMovies) {
                top.linkTo(recyclerLastWatch.bottom, 25.dp)
                start.linkTo(recyclerLastWatch.start)
            })
        LazyRow(
            modifier = Modifier
                .constrainAs(recyclerPopularMovies) {
                    top.linkTo(txtPopularMovies.bottom, 15.dp)
                    start.linkTo(txtPopularMovies.start)
                }
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.Transparent),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(getPopularMoviesListData()) { item ->
                RecyclerLayout(item)
            }
        }

    }

}


data class VideosList(val name: String, val smallBannerImage: Int) {
}

@Composable
fun RecyclerLayout(items: VideosList) {
    ConstraintLayout {
        val (card, image, text) = createRefs()
        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Black)
                .size(150.dp)
                .constrainAs(card) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
           // border = BorderStroke(2.dp, Color.White)
        ) {
            ConstraintLayout {

                Image(
                    painter = painterResource(id = items.smallBannerImage),
                    contentDescription = "",
                    modifier = Modifier
                        .background(
                            Color.Black
                        )
                        .fillMaxSize()
                        .constrainAs(image) {
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    contentScale = ContentScale.Crop

                )
                Text(
                    text = items.name,
                    color = Color.White,
                    modifier = Modifier
                        .constrainAs(text) {
                            top.linkTo(image.bottom, margin = 10.dp)
                            start.linkTo(image.start)
                            end.linkTo(image.end)
                            bottom.linkTo(parent.bottom)
                        })
            }


        }
    }


}

fun getContinueWatchingListData(): MutableList<VideosList> {
    val list = mutableListOf<VideosList>()
    list.add(
        VideosList("Benz CL63", R.drawable.banner2),
    )
    list.add(
        VideosList("Kompossor 200", R.drawable.banner3),

        )
    list.add(
        VideosList("AMG CL64", R.drawable.banner4)
    )
    list.add(
        VideosList("Kompossor 200", R.drawable.banner5),

        )
    list.add(
        VideosList("AMG CL64", R.drawable.banner6)
    )
    list.add(
        VideosList("Benz CL63", R.drawable.banner2),
    )
    list.add(
        VideosList("Kompossor 200", R.drawable.banner3),

        )
    list.add(
        VideosList("AMG CL64", R.drawable.banner4)
    )
    list.add(
        VideosList("Kompossor 200", R.drawable.banner5),

        )
    list.add(
        VideosList("AMG CL64", R.drawable.banner6)
    )
    return list
}

fun getLastWatchListData(): MutableList<VideosList> {
    val list = mutableListOf<VideosList>()
    list.add(
        VideosList("Benz CL63", R.drawable.banner7),
    )
    list.add(
        VideosList("Kompossor 200", R.drawable.banner8),

        )
    list.add(
        VideosList("AMG CL64", R.drawable.banner9)
    )
    list.add(
        VideosList("Kompossor 200", R.drawable.banner10),

        )
    list.add(
        VideosList("AMG CL64", R.drawable.banner11)
    )
    list.add(
        VideosList("Benz CL63", R.drawable.banner2),
    )
    list.add(
        VideosList("Kompossor 200", R.drawable.banner3),

        )
    list.add(
        VideosList("AMG CL64", R.drawable.banner4)
    )
    list.add(
        VideosList("Kompossor 200", R.drawable.banner5),

        )
    list.add(
        VideosList("AMG CL64", R.drawable.banner6)
    )
    return list
}

fun getPopularMoviesListData(): MutableList<VideosList> {
    val list = mutableListOf<VideosList>()
    list.add(
        VideosList("Benz CL63", R.drawable.banner1),
    )
    list.add(
        VideosList("Kompossor 200", R.drawable.banner2),

        )
    list.add(
        VideosList("AMG CL64", R.drawable.banner3)
    )
    list.add(
        VideosList("Kompossor 200", R.drawable.banner4),

        )
    list.add(
        VideosList("AMG CL64", R.drawable.banner5)
    )
    list.add(
        VideosList("Benz CL63", R.drawable.banner2),
    )
    list.add(
        VideosList("Kompossor 200", R.drawable.banner3),

        )
    list.add(
        VideosList("AMG CL64", R.drawable.banner4)
    )
    list.add(
        VideosList("Kompossor 200", R.drawable.banner5),

        )
    list.add(
        VideosList("AMG CL64", R.drawable.banner6)
    )
    return list
}
