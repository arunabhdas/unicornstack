package app.unicornapp.mobile.android.unicorn.data.parser

import java.io.InputStream
import app.unicornapp.mobile.android.unicorn.domain.model.StockListing
import com.opencsv.CSVReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStreamReader
import javax.inject.Inject
import javax.inject.Singleton


/**
 * StockListingsParser
 */
@Singleton
class StockListsingsParser @Inject constructor(): CsvParser<StockListing> {
    override suspend fun parse(stream: InputStream): List<StockListing> {
        val csvReader = CSVReader(InputStreamReader(stream))
        return withContext(Dispatchers.IO) {
            csvReader.readAll()
                .drop(1)
                .mapNotNull { line ->
                    val symbol = line.getOrNull(0)
                    val name = line.getOrNull(1)
                    val exchange = line.getOrNull(2)
                    StockListing(
                        name = name ?: return@mapNotNull null,
                        symbol = symbol ?: return@mapNotNull null,
                        exchange = exchange ?: return@mapNotNull null
                    )
                }
                .also {
                    csvReader.close()
                }
        }
    }
}