package app.unicornapp.mobile.android.unicorn.data.remote

import app.unicornapp.mobile.android.unicorn.BuildConfig
import okhttp3.ResponseBody
import retrofit2.http.Query

/**
 * StockApi
 */
interface StocksApi {
    suspend fun getListings(
        @Query("apikey") apiKey: String = API_KEY
    ): ResponseBody

    companion object {
        val API_KEY = BuildConfig.API_KEY
        val STOCKS_BASE_URL = BuildConfig.STOCKS_BASE_URL
    }
}