package app.unicornapp.mobile.android.unicorn.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * StockListingEntity
 */
@Entity

data class StockListingEntity (
    val name: String,
    val symbol: String,
    val exchange: String,
    @PrimaryKey val id: Int? = null

)