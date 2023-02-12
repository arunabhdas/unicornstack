package app.unicornapp.mobile.android.unicorn.presentation.company_listings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.unicornapp.mobile.android.unicorn.domain.repository.StockRepository
import app.unicornapp.mobile.android.unicorn.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * StockListingsViewModel
 */
@HiltViewModel
class CompanyListingsViewModel @Inject constructor(
    private val repository: StockRepository
): ViewModel() {
    var state by mutableStateOf(CompanyListingsState())

    private var searchJob: Job? = null
    fun onEvent(event: CompanyListingsEvent) {
        when(event) {
            is CompanyListingsEvent.Refresh -> {
                getCompanyListings(fetchFromRemote = true)
            }

            is CompanyListingsEvent.OnSearchQueryChange -> {

            }
        }
    }

    fun getCompanyListings(
        query: String = state.searchQuery.lowercase(),
        fetchFromRemote: Boolean = false
    ) {
        viewModelScope.launch {
            repository
                .getStockListings(fetchFromRemote, query)
                .collect { result ->
                    when (result) {
                        is Resource.Succes -> {
                            result.data?.let { listings ->
                                state = state.copy(

                                )
                            }
                        }
                        is Resource.Error -> {

                        }
                        is Resource.Loading -> {
                            state = state.copy(isLoading = result.isLoading)
                        }

                    }
                }
        }
    }

}