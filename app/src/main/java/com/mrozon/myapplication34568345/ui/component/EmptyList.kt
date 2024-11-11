package com.mrozon.myapplication34568345.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mrozon.common.compose.ThemePreviews
import com.mrozon.common.compose.component.MyText
import com.mrozon.common.compose.model.AwesomeText
import com.mrozon.myapplication34568345.R
import com.mrozon.myapplication34568345.ui.theme.MyApplication34568345Theme

@Composable
fun EmptyList(
    modifier: Modifier = Modifier,
    addItem: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.empty_list),
                "",
                modifier = modifier.size(150.dp),
            )
            MyText(
                AwesomeText.Resource(R.string.empty),
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            OutlinedButton(
                onClick = addItem,
                modifier = Modifier.defaultMinSize(minWidth = 200.dp)
            ) {
                MyText(
                    AwesomeText.Resource(R.string.add_first_item),
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }

    }
}

@ThemePreviews
@Composable
fun EmptyListPreview(){
    MyApplication34568345Theme {
        EmptyList {

        }
    }
}