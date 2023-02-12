package app.unicornapp.mobile.android.unicorn.domain.model

import androidx.room.Entity

/**
 * CompanyListing
 */
@Entity
data class CompanyListing (
    val name: String,
    val symbol: String,
    val exchange: String,
)