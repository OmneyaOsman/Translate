package com.omni.myapplication.android.translate.presentation

import androidx.lifecycle.ViewModel
import com.omni.myapplication.translate.domain.history.HistoryDataSource
import com.omni.myapplication.translate.domain.translate.Translate
import com.omni.myapplication.translate.presentation.TranslateViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.omni.myapplication.translate.presentation.TranslateEvent

@HiltViewModel
class AndroidTranslateViewModel @Inject constructor(
    private val translate: Translate,
    private val historyDataSource: HistoryDataSource
):ViewModel() {
    val viewModel : TranslateViewModel by lazy {
        TranslateViewModel(translate,historyDataSource , coroutineScope = viewModelScope)
    }

    val state = viewModel.state

    fun onEvent(event: TranslateEvent) {
        viewModel.onEvent(event)
    }
}