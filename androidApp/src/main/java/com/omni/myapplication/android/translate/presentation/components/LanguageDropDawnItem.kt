package com.omni.myapplication.android.translate.presentation.components

import androidx.compose.material.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.omni.myapplication.core.presentation.UiLanguage

@Composable
fun LanguageDropDawnItem(
    language: UiLanguage,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    DropdownMenuItem(onClick = onClick) {

    }
}