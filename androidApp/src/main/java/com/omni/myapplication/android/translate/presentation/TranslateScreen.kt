package com.omni.myapplication.android.translate.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.omni.myapplication.android.translate.presentation.components.SwapLanguageButton
import com.omni.myapplication.translate.presentation.TranslateEvent
import com.omni.myapplication.translate.presentation.TranslateState

@Composable
fun TranslateScreen(state: TranslateState, onEvent: (TranslateEvent) -> Unit) {
    Scaffold(floatingActionButton = {}) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            item {
                Row(modifier = Modifier.fillMaxWidth()) {
                    SwapLanguageButton(onClick = { onEvent(TranslateEvent.SwapLanguages) })
                }
            }

        }

    }
}