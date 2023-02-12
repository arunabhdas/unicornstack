package app.unicornapp.mobile.android.unicorn.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * StockDatabase
 */

@Database(
    entities = [CompanyListingEntity::class],
    version = 1

)
abstract class StockDatabase: RoomDatabase() {
    abstract val dao: StockDao
}