import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.tv.foundation.lazy.list.TvLazyColumn
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.foundation.lazy.list.items
import androidx.tv.foundation.lazy.list.rememberTvLazyListState
import com.example.tamashatv.R

@Preview(
    widthDp = 1080,
    heightDp = 720,
    showBackground = true,
    backgroundColor = 0x000000
)
@Composable
fun DashboardScreen() {
    val lazyColumnScrollState = rememberTvLazyListState()
    TvLazyColumn(
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier.background(Color.Black),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(15.dp), state = lazyColumnScrollState
    ) {
        item {
            Text("Continue Watching", color = Color.White, fontSize = 25.sp)
        }
        item {
            TvLazyRow {
                items(getLastWatchListData()) { items ->
                    RecyclerLayout(items)
                }
            }
        }
        item {
            Text("Popular Movies ", color = Color.White, fontSize = 25.sp)
        }
        item {
            TvLazyRow {
                items(getPopularMoviesListData()) { items ->
                    RecyclerLayout(items)
                }
            }
        }
        item {
            Text("Your List", color = Color.White, fontSize = 25.sp)
        }
        item {
            TvLazyRow {
                items(getLastWatchListData()) { items ->
                    RecyclerLayout(items)
                }
            }
        }
        item {
            Text("Last Watched", color = Color.White, fontSize = 25.sp)
        }
        item {
            TvLazyRow {
                items(getContinueWatchingListData()) { items ->
                    RecyclerLayout(items)
                }
            }
        }
    }
}
data class VideosList(val name: String, val smallBannerImage: Int)

@Composable
fun RecyclerLayout(items: VideosList) {
    ConstraintLayout(
        modifier = Modifier
            .focusable()
    ) {
        val (card, image, text) = createRefs()
        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Transparent)
                .constrainAs(card) {
                    top.linkTo(parent.top, 10.dp)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                }
                .focusable(),
//             border = BorderStroke(2.dp, Color.White)
        ) {
            ConstraintLayout(
                modifier = Modifier
                    .background(Color.Black)
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = items.smallBannerImage),
                    contentDescription = "",
                    modifier = Modifier
                        .height(180.dp)
                        .width(220.dp)
                        .constrainAs(image) {
                            top.linkTo(parent.top)
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
                            bottom.linkTo(parent.bottom, 5.dp)
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
