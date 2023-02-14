package app.unicornapp.mobile.android.unicorn.presentation.company_listings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.ui.Modifier
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
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
    val refreshScope = rememberCoroutineScope()
    var refreshing by remember { mutableStateOf(false) }
    var itemCount by remember { mutableStateOf(15) }

    fun refresh() = refreshScope.launch {
        refreshing = true
        delay(1500)
        itemCount += 5
        refreshing = false
    }

    val swipeRefreshState = rememberPullRefreshState(refreshing, ::refresh)

    val state = viewModel.state

    Column(
        modifier = Modifier.fillMaxSize()

    ) {
        OutlinedTextField(
            value = state.searchQuery,
            onValueChange = { newQuery ->
                viewModel.onEvent(
                    CompanyListingsEvent.OnSearchQueryChange(newQuery)
                )
            }
        )
    }
}
