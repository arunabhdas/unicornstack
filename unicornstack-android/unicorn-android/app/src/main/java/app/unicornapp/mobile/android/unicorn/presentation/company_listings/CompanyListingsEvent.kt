package app.unicornapp.mobile.android.unicorn.presentation.company_listings

/**
 * CompanyListingsEvent
 */
sealed class CompanyListingsEvent {
    object Refresh: CompanyListingsEvent()
    data class OnSearchQueryChange(val query: String): CompanyListingsEvent()
}
