package com.mrozon.myapplication34568345.ui.screen.list

import com.mrozon.common.core.mvi.ViewEvent
import com.mrozon.common.core.mvi.ViewSideEffect
import com.mrozon.myapplication34568345.domain.model.ToDoItem

object ListContract {

    data class State(
        val uiState: UiState? = null,
        val items: List<ToDoItem> = emptyList()
    )

    sealed interface UiState {
        data class Error(val message: String): UiState
        data object Content: UiState
        data object Loading: UiState
    }

    sealed class  Event : ViewEvent {

    }

    sealed class SideEffect: ViewSideEffect {

    }
}