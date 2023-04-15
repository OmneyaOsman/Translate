package com.omni.myapplication.translate.domain.history

import com.omni.myapplication.core.domain.util.CommonFlow
import database.HistoryEntity

interface HistoryDataSource {
    fun getHistory():CommonFlow<List<HistoryItem>>
    suspend fun insertHistoryItem(item: HistoryItem)
}