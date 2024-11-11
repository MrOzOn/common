package com.mrozon.myapplication34568345.ui.screen.list

import androidx.lifecycle.SavedStateHandle
import com.mrozon.common.core.ext.showParams
import com.mrozon.common.core.mvi.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    stateHandle: SavedStateHandle,
): BaseViewModel<ListContract.Event, ListContract.State, ListContract.SideEffect>(){

    init {
        Timber.d("init vw with ${stateHandle.showParams()}")
    }

    override fun setInitialState() = ListContract.State()

}