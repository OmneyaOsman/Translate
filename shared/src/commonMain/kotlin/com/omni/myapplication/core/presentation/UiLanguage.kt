package com.omni.myapplication.core.presentation

import com.omni.myapplication.core.domain.language.Language

expect class UiLanguage{
    val language: Language
    companion object {
        fun byCode(langCode: String): UiLanguage
        val allLanguages: List<UiLanguage>
    }
}