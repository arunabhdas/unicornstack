package app.unicornapp.mobile.android.unicorn.domain.model

import androidx.room.Entity

/**
 * StockListing
 */
@Entity
data class StockListing (
    val name: String,
    val symbol: String,
    val exchange: String,
)