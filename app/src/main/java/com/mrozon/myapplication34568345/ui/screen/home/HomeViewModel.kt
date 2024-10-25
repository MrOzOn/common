package com.mrozon.myapplication34568345.ui.screen.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.mrozon.common.core.ext.showParams
import com.mrozon.common.core.mvi.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    stateHandle: SavedStateHandle,
): BaseViewModel<HomeContract.Event, HomeContract.State, HomeContract.SideEffect>() {

    init {
        Timber.d("init vw with ${stateHandle.showParams()}")
    }

    override fun setInitialState() = HomeContract.State()

    override fun handleEvents(event: HomeContract.Event) {
       when(event) {
           HomeContract.Event.DecreaseCounter ->
               viewModelScope.launch(Dispatchers.Main) {
                   setState { copy(counter = this.counter - 1) }
                   checkCounter()
               }

           HomeContract.Event.IncreaseCounter ->
               viewModelScope.launch(Dispatchers.Main) {
                   setState { copy(counter = this.counter + 1) }
                   checkCounter()
               }
       }
    }

    private fun checkCounter(){
        if (viewState.value.counter % 10 == 0)
            setEffect { HomeContract.SideEffect.RememberCounter }
    }

}