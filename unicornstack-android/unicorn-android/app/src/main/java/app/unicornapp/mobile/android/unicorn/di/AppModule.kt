package app.unicornapp.mobile.android.unicorn.di

import android.app.Application
import androidx.room.Room
import app.unicornapp.mobile.android.unicorn.data.local.StockDatabase
import app.unicornapp.mobile.android.unicorn.data.remote.StocksApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

/**
 * AppModule
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesStockApi(): StocksApi {
        return Retrofit.Builder()
            .baseUrl(StocksApi.STOCKS_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun providesStockDatabase(app: Application): StockDatabase {
        return Room.databaseBuilder(
            app,
            StockDatabase::class.java,
            "stockdb.db"
        ).build()
    }
}