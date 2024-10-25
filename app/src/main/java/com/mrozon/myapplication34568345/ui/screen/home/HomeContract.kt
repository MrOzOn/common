package com.mrozon.myapplication34568345.ui.screen.home

import com.mrozon.common.core.mvi.ViewEvent
import com.mrozon.common.core.mvi.ViewSideEffect

object HomeContract {

    data class State(
        val counter: Int = 0,
    )

    sealed class  Event : ViewEvent {
        data object IncreaseCounter: Event()
        data object DecreaseCounter: Event()
    }

    sealed class SideEffect: ViewSideEffect {
        data object RememberCounter: SideEffect()
    }
}