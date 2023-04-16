package com.omni.myapplication.translate.domain.translate

import com.omni.myapplication.core.domain.util.Resource
import com.omni.myapplication.translate.domain.history.HistoryDataSource
import com.omni.myapplication.translate.domain.history.HistoryItem
import com.plcoding.translator_kmm.core.domain.language.Language

class Translate(
    private val client: TranslateClient,
    private val historyDataSource: HistoryDataSource
) {
    suspend fun execute(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ):Resource<String> {
      return  try {
            val translatedText = client.translate(fromLanguage, fromText, toLanguage)
            historyDataSource.insertHistoryItem(
                HistoryItem(
                    null,
                    fromLanguage.langCode,
                    fromText,
                    toLanguage.langCode,
                    translatedText
                )
            )
            Resource.Success(translatedText)
        } catch (e: TranslateException) {
            e.printStackTrace()
            Resource.Error(e)
        }
    }
}