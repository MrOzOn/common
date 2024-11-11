package com.mrozon.myapplication34568345.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mrozon.common.compose.ThemePreviews
import com.mrozon.common.compose.component.MyText
import com.mrozon.common.compose.model.AwesomeText
import com.mrozon.myapplication34568345.R
import com.mrozon.myapplication34568345.ui.theme.MyApplication34568345Theme

@Composable
fun ErrorMessage(
    text: String,
    modifier: Modifier = Modifier,
    onClose: () -> Unit
) {
    Box(
    modifier = modifier.fillMaxSize()
        .background(MaterialTheme.colorScheme.primaryContainer),
    contentAlignment = Alignment.Center
) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.error_icon),
                contentDescription = "",
                modifier = modifier.size(100.dp),
//                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.error)
            )
//            MyText(
//                AwesomeText.Resource(R.string.error),
//                color = MaterialTheme.colorScheme.onPrimaryContainer,
//                style = MaterialTheme.typography.headlineSmall
//            )

            MyText(
                AwesomeText.PlainText(text),
                modifier = modifier.padding(horizontal = 16.dp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(
                modifier = Modifier.height(20.dp)
            )
            Button(
                onClick = onClose,
                modifier = Modifier.padding(horizontal = 32.dp)
            ) {
                MyText(
                    AwesomeText.Resource(R.string.close),
                    modifier = modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
//                    style = MaterialTheme.typography.bodyMedium
                )
            }

        }
    }
}

@ThemePreviews
@Composable
fun ErrorMessagePreview(){
    MyApplication34568345Theme {
        ErrorMessage(
            text = "jsdhfjkdshjfhjdskhfjksd sdjfsd sfsdfv"
        ) {

        }
    }
}