package app.unicornapp.mobile.android.unicorn.data.mapper

import app.unicornapp.mobile.android.unicorn.data.local.StockListingEntity
import app.unicornapp.mobile.android.unicorn.domain.model.StockListing

/**
 * StockMapper
 */

fun StockListingEntity.toStockListing(): StockListing {
    return StockListing(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun StockListing.toStockListingEntity(): StockListingEntity {
    return StockListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}