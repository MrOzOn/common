package com.mrozon.common.compose.ext

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mrozon.common.compose.model.AwesomeText

@Composable
fun AwesomeText.getText() =
    when(this) {
        is AwesomeText.PlainText -> rawText
        is AwesomeText.Resource -> stringResource(id = resId)
        is AwesomeText.ResourceParams -> stringResource(id = value, args)
    }