package app.unicornapp.mobile.android.unicorn.data.repository

import app.unicornapp.mobile.android.unicorn.data.local.StockDatabase
import app.unicornapp.mobile.android.unicorn.data.mapper.toStockListing
import app.unicornapp.mobile.android.unicorn.data.remote.StocksApi
import app.unicornapp.mobile.android.unicorn.domain.model.StockListing
import app.unicornapp.mobile.android.unicorn.domain.repository.StockRepository
import app.unicornapp.mobile.android.unicorn.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * StockRepositoryImpl
 */
@Singleton
class StockRepositoryImpl @Inject constructor(
    val stockApi: StocksApi,
    val db: StockDatabase
): StockRepository {
    private val dao = db.dao
    override suspend fun getStockListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<StockListing>>> {
        return flow {
            emit(Resource.Loading(true))
            val localListings = dao.searchStockListing(query)
            emit(Resource.Succes(
                data = localListings.map { stockListingEntity ->
                   stockListingEntity.toStockListing()
                }
            ))
            val isDbEmpty = localListings.isEmpty() && query.isBlank()
            val shouldJustLoadFromCache = !isDbEmpty && !fetchFromRemote

            if  (shouldJustLoadFromCache) {
                emit(Resource.Loading(false))
                return@flow
            }
            val remoteListings = try {
                val response = stockApi.getListings()
                response.byteStream()
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Could not load data"))
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Could not load data"))
            }
        }
    }
}