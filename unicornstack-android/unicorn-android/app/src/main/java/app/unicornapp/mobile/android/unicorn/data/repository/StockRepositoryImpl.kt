package app.unicornapp.mobile.android.unicorn.data.repository

import app.unicornapp.mobile.android.unicorn.data.local.StockDatabase
import app.unicornapp.mobile.android.unicorn.data.mapper.toCompanyListing
import app.unicornapp.mobile.android.unicorn.data.mapper.toCompanyListingEntity
import app.unicornapp.mobile.android.unicorn.data.parser.CsvParser
import app.unicornapp.mobile.android.unicorn.data.remote.StocksApi
import app.unicornapp.mobile.android.unicorn.domain.model.CompanyListing
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
    val db: StockDatabase,
    val csvParser: CsvParser<CompanyListing>
): StockRepository {
    private val dao = db.dao
    override suspend fun getStockListings(
        fetchFromRemote: Boolean,
        query: String
    ): Flow<Resource<List<CompanyListing>>> {
        return flow {
            emit(Resource.Loading(true))
            val localListings = dao.searchCompanyListing(query)
            emit(Resource.Succes(
                data = localListings.map { entity ->
                   entity.toCompanyListing()
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
                csvParser.parse(response.byteStream())
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error("Could not load data"))
                null
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error("Could not load data"))
                null
            }

            remoteListings?.let {listings ->
                dao.clearCompanyListings()
                dao.insertConpanyListings(
                    listings.map { listing ->
                        listing.toCompanyListingEntity()
                    }
                )
                emit(Resource.Succes(
                    data = dao.searchCompanyListing("")
                        .map { entity ->
                            entity.toCompanyListing()
                        }
                ))
                emit(Resource.Loading(false))
            }
        }
    }
}