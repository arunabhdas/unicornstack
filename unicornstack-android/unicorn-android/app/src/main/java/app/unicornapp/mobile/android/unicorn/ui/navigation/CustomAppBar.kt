package app.unicornapp.mobile.android.unicorn.ui.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.unicornapp.mobile.android.unicorn.R

/**
 * AppBar
*/

@Composable
fun CustomAppBar(
    onNavigationIconClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
    ) {
        TopAppBar(
            title = {
                Text(text = "")
            },
            backgroundColor = Color.Transparent,
            modifier = Modifier.padding(top = 60.dp),
            elevation = 0.dp,
            navigationIcon = {
                IconButton(onClick = onNavigationIconClick) {
                    Icon(
                        imageVector = Icons.Rounded.Menu,
                        tint = Color.White,
                        contentDescription = "Toggle"
                    )
                }
            }
        )
    }
}

@Preview
@Composable
fun CustomAppBarPreview() {
   CustomAppBar(
       {}
   )
}