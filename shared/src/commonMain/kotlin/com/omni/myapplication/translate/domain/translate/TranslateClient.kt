package com.omni.myapplication.translate.domain.translate

import com.omni.myapplication.core.domain.language.Language

interface TranslateClient {
    suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String
}