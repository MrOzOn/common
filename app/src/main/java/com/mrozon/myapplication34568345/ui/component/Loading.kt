package com.mrozon.myapplication34568345.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mrozon.common.compose.ThemePreviews
import com.mrozon.myapplication34568345.ui.theme.MyApplication34568345Theme

@Composable
fun Loading(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = modifier.size(160.dp),
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            strokeWidth = 4.dp,
        )
    }
}

@ThemePreviews
@Composable
fun LoadingPreview(){
    MyApplication34568345Theme {
        Loading()
    }
}