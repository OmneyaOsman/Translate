package com.omni.myapplication.translate.data.history

import com.omni.myapplication.core.domain.util.CommonFlow
import com.omni.myapplication.core.domain.util.toCommonFlow
import com.omni.myapplication.database.translateDatabase
import com.omni.myapplication.translate.domain.history.HistoryDataSource
import com.omni.myapplication.translate.domain.history.HistoryItem
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock

class SqlDelightHistoryDataSource(db: translateDatabase) : HistoryDataSource {

    private val queries = db.translateQueries
    override fun getHistory(): CommonFlow<List<HistoryItem>> {
        return queries.getHistory().asFlow().mapToList().map { history ->
            history.map {
                it.toHistoryItem()
            }
        }.toCommonFlow()
    }

    override suspend fun insertHistoryItem(item: HistoryItem) {
        queries.insertHistory(
            id = item.id,
            fromLanguageCode = item.fromLanguageCode,
            fromText = item.fromText,
            toLanguageCode = item.toLanguageCode,
            toText = item.toText, timestamp = Clock.System.now().toEpochMilliseconds()
        )
    }
}