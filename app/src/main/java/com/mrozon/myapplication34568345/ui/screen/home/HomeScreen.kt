package com.mrozon.myapplication34568345.ui.screen.home

import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mrozon.common.compose.MultiLanguagePreview
import com.mrozon.common.compose.ThemePreviews
import com.mrozon.common.compose.component.MyText
import com.mrozon.common.compose.model.AwesomeText
import com.mrozon.myapplication34568345.R
import com.mrozon.myapplication34568345.ui.theme.MyApplication34568345Theme
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
){
    val context = LocalContext.current
    LaunchedEffect(viewModel.effect) {
        viewModel.effect.onEach { effect ->
            when(effect) {
                HomeContract.SideEffect.RememberCounter ->
                    Toast.makeText(context, "Hurray!!!", LENGTH_SHORT).show()
            }
        }.collect()
    }
    HomeScreen(
        state = viewModel.viewState.value,
        modifier = modifier,
        onEvent = viewModel::setEvent
    )
}

@Composable
internal fun HomeScreen(
    state: HomeContract.State,
    modifier: Modifier = Modifier,
    onEvent: (HomeContract.Event) -> Unit = {},
){
    Box(
        modifier = modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
            .padding(horizontal = 32.dp),
        contentAlignment = Alignment.Center,
    ){
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            MyText(
                AwesomeText.PlainText("counter"),
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.primary
            )
            MyText(
                AwesomeText.PlainText("${state.counter}"),
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Button(onClick = {
                    onEvent(HomeContract.Event.DecreaseCounter)
                }) { MyText(AwesomeText.Resource(R.string.decrease))}
                Button(onClick = {
                    onEvent(HomeContract.Event.IncreaseCounter)
                }) { MyText(AwesomeText.Resource(R.string.increase))}
            }
        }
    }
}

@ThemePreviews
//@MultiLanguagePreview
@Composable
fun HomeScreenPreview() {
    MyApplication34568345Theme {
        HomeScreen(
            state = HomeContract.State(34)
        )
    }
}