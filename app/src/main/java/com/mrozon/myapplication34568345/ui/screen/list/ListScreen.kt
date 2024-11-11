package com.mrozon.myapplication34568345.ui.screen.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mrozon.common.compose.ThemePreviews
import com.mrozon.myapplication34568345.domain.model.ToDoItem
import com.mrozon.myapplication34568345.ui.component.EmptyList
import com.mrozon.myapplication34568345.ui.component.ErrorMessage
import com.mrozon.myapplication34568345.ui.component.Loading
import com.mrozon.myapplication34568345.ui.component.ToDoNote
import com.mrozon.myapplication34568345.ui.theme.MyApplication34568345Theme
import kotlinx.datetime.Clock

@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    viewModel: ListViewModel = hiltViewModel(),
    navController: NavController,
){

}

@Composable
internal fun ListScreen(
    state: ListContract.State,
    modifier: Modifier = Modifier,
    onEvent: (ListContract.Event) -> Unit = {},
){
    state.uiState?.let {
        when(state.uiState) {
            is ListContract.UiState.Error -> ErrorMessage(state.uiState.message, modifier) { }
            ListContract.UiState.Loading -> Loading(modifier)
            is ListContract.UiState.Content -> {
                if (state.items.isEmpty()) {
                    EmptyList(modifier) {  }
                } else {
                    Box(
                        modifier = modifier.fillMaxSize()
                            .background(MaterialTheme.colorScheme.surfaceContainer.copy(alpha = 0.9f)),
                    ){
                        LazyColumn(

                        ) {
                            items(state.items) { item ->
                                ToDoNote(item)
                            }
                        }
                        FloatingActionButton(
                            onClick = {},
                            modifier = modifier.align(Alignment.BottomEnd).padding(32.dp)
                        ) {
                            Icon(Icons.Filled.Add, "Localized description")
                        }
                    }
                }
            }
        }
    }
}

@ThemePreviews
//@MultiLanguagePreview
@Composable
fun HomeScreenPreview() {
    MyApplication34568345Theme {
        ListScreen(
            state = ListContract.State(
                items = listOf(
                    ToDoItem(
                        id = 2661,
                        title = "senserit",
                        content = "alisdfdsfquid",
                        created = Clock.System.now(),
                        completed = true
                    ),
                    ToDoItem(
                        id = 2661,
                        title = "senseritsadsad",
                        content = "aliqsdfsdfuid",
                        created = Clock.System.now(),
                        completed = false
                    ),
                    ToDoItem(
                        id = 2661,
                        title = "senseriasdsadt",
                        content = "aliqsadsaduid",
                        created = Clock.System.now(),
                        completed = false
                    ),
                ),
                uiState = ListContract.UiState.Content
            )
        )
    }
}