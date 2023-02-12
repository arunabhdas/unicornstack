package app.unicornapp.mobile.android.unicorn.data.mapper

import app.unicornapp.mobile.android.unicorn.data.local.CompanyListingEntity
import app.unicornapp.mobile.android.unicorn.domain.model.CompanyListing

/**
 * StockMapper
 */

fun CompanyListingEntity.toCompanyListing(): CompanyListing {
    return CompanyListing(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}

fun CompanyListing.toCompanyListingEntity(): CompanyListingEntity {
    return CompanyListingEntity(
        name = name,
        symbol = symbol,
        exchange = exchange
    )
}