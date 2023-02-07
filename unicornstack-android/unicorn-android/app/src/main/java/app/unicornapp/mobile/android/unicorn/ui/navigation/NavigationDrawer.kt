package app.unicornapp.mobile.android.unicorn.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.unicornapp.mobile.android.unicorn.R
import kotlinx.coroutines.launch


@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Unicorn", fontSize = 60.sp)
    }

}

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    modifier: Modifier = Modifier,
    itemTextStyle: TextStyle = TextStyle(fontSize = 18.sp),
    onItemClick: (MenuItem) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 64.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Unicorn", fontSize = 60.sp)
        }
        Image(
            painterResource(id = R.drawable.banner_bg_2),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painterResource(id = R.drawable.unicorn_white),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(16.dp))

            }
            LazyColumn(modifier) {
                items(items) { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onItemClick(item)
                            }
                            .padding(32.dp)
                    ) {
                        Icon(
                            imageVector = item.icon,
                            tint = Color.White,
                            contentDescription = item.contentDescription
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = item.title,
                            style = itemTextStyle,
                            color = Color.White,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DrawerBodyPreview() {
    DrawerBody(
        items = listOf(
            MenuItem(
                id = "home",
                title = "Home",
                route = "home_screen",
                contentDescription = "Navigate to Home",
                icon = Icons.Default.Home
            ),
            MenuItem(
                id = "contact",
                title = "Contact",
                route = "contact_screen",
                contentDescription = "Navigate to Contact",
                icon = Icons.Default.Email
            ),
            MenuItem(
                id = "notifications",
                title = "Notification",
                route = "notification_screen",
                contentDescription = "Navigate to Notifications",
                icon = Icons.Default.Notifications
            )
        ),
        onItemClick = {menuItem ->
        }
    )
}