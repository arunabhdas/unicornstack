package app.unicornapp.mobile.android.unicorn.presentation.company_listings

import app.unicornapp.mobile.android.unicorn.domain.model.CompanyListing

/**
 * CompanyListingsState
 */
data class CompanyListingsState(
    val stocks: List<CompanyListing> = emptyList(),
    val isLoading: Boolean = false,
    val isRefreshing: Boolean = false,
    val searchQuery: String = ""
)
