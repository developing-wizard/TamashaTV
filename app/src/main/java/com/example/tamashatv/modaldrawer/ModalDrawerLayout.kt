import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.tamashatv.modaldrawer.ModalDrawerItem


@Composable
fun ModalDrawerLayout(
    items: List<ModalDrawerItem>,
    currentRoute: String?,
    onClick: (ModalDrawerItem) -> Unit,
) {
    ModalDrawerSheet {
        Column(
            Modifier
                .background(Color.Gray)
                .fillMaxHeight()
                .selectableGroup()
                .padding(5.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            items.forEachIndexed { _, modalDrawerItem ->
                NavigationDrawerItem(
                    colors = NavigationDrawerItemDefaults.colors(
                        selectedIconColor = Color.Blue,
                        unselectedIconColor = Color.Black,
                        selectedTextColor = Color.Black,
                        unselectedTextColor = Color.White,
                        selectedContainerColor = Color.LightGray,
                        unselectedContainerColor = Color.Transparent
                    ),

                    selected = currentRoute == modalDrawerItem.route,
                    onClick = {
                        onClick(modalDrawerItem)
                    },
//                    icon = {
//                        Icon(
//                            imageVector = if (currentRoute == modalDrawerItem.route) {
//                                modalDrawerItem.selectedIcon
//                            } else {
//                                modalDrawerItem.unSelectedIcon
//                            },
//                            contentDescription = modalDrawerItem.title
//                        )
//                    },
                    label = {
                        Text(
                            text = modalDrawerItem.title
                        )
                    }
                )
            }
        }
    }
}

