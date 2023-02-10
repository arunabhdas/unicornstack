package app.unicornapp.mobile.android.unicorn.data.parser

import java.io.InputStream

/**
 * CsvParser
 */
interface CsvParser<T> {
    suspend fun parse(stream: InputStream): List<T>
}