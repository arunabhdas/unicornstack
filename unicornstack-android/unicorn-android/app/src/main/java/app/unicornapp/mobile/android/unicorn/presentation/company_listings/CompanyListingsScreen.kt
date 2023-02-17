package app.unicornapp.mobile.android.unicorn.presentation.company_listings

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.ui.Modifier
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import app.unicornapp.mobile.android.unicorn.R
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * CompanyListingsScreen
 */
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CompanyListingsScreen(
    navController: NavController,
    viewModel: CompanyListingsViewModel = hiltViewModel()
) {
    val swipeRefreshState = rememberSwipeRefreshState(
        isRefreshing = viewModel.state.isRefreshing
    )
    val state = viewModel.state
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painterResource(
                id = R.drawable.banner_bg_2
            ),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column(
            modifier = Modifier.fillMaxSize()

        ) {
            OutlinedTextField(
                value = state.searchQuery,
                onValueChange = { newQuery ->
                    viewModel.onEvent(
                        CompanyListingsEvent.OnSearchQueryChange(newQuery)
                    )
                },
                modifier = Modifier
                    .padding(48.dp)
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        text = "Search...",
                        color = Color.White,
                        fontSize = MaterialTheme.typography.titleSmall.fontSize,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedLabelColor = MaterialTheme.colorScheme.inversePrimary,
                    textColor = Color.White
                ),
                maxLines = 1,
                singleLine = true
            )
            SwipeRefresh(
                state = swipeRefreshState,
                onRefresh = {
                    viewModel.onEvent(CompanyListingsEvent.Refresh)
                }
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(state.companies.size) {i ->
                        val company = state.companies[i]
                        CompanyItem(
                            company = company,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    // TODO-FIXME Navigate to detail screen
                                }
                                .padding(16.dp)
                        )
                        if (i < state.companies.size) {
                            Divider(modifier = Modifier.padding(
                                horizontal = 16.dp
                            ))
                        }
                    }
                }
            }
        }
    }

}
@Preview(showBackground = true)
@Composable
fun PreviewCompanyListingsScreen(
) {
    CompanyListingsScreen(
        navController = rememberNavController(),
        viewModel = hiltViewModel()
    )
}