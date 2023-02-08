package app.unicornapp.mobile.android.unicorn.data.remote

import retrofit2.http.Query

/**
 * StockApi
 */
interface StockApi {
    suspend fun getListings(
        @Query("apikey") apiKey: String
    )


}