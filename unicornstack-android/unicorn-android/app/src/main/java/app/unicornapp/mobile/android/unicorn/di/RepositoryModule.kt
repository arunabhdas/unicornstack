package app.unicornapp.mobile.android.unicorn.di

import app.unicornapp.mobile.android.unicorn.data.parser.CompanyListingsParser
import app.unicornapp.mobile.android.unicorn.data.parser.CsvParser
import app.unicornapp.mobile.android.unicorn.data.repository.StockRepositoryImpl
import app.unicornapp.mobile.android.unicorn.domain.model.CompanyListing
import app.unicornapp.mobile.android.unicorn.domain.repository.StockRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * RepositoryModule
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindCompanyListingsParser(
        companyListingsParser: CompanyListingsParser
    ): CsvParser<CompanyListing>

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        stockRepositoryImpl: StockRepositoryImpl
    ): StockRepository
}