package app.unicornapp.mobile.android.unicorn.domain.repository

import app.unicornapp.mobile.android.unicorn.domain.model.CompanyListing
import app.unicornapp.mobile.android.unicorn.util.Resource
import kotlinx.coroutines.flow.Flow

/**
 * StockRepository
 */
interface StockRepository {
    suspend fun getStockListings(
        fetchFromRemote: Boolean,
        query: String
    ) : Flow<Resource<List<CompanyListing>>>
}