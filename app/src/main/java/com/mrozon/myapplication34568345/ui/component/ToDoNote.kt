package com.mrozon.myapplication34568345.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.mrozon.common.compose.ThemePreviews
import com.mrozon.common.compose.component.MyText
import com.mrozon.common.compose.model.AwesomeText
import com.mrozon.common.core.ext.toSimpleFormat
import com.mrozon.myapplication34568345.R
import com.mrozon.myapplication34568345.domain.model.ToDoItem
import com.mrozon.myapplication34568345.ui.theme.MyApplication34568345Theme
import kotlinx.datetime.Clock

@Composable
fun ToDoNote(
    item: ToDoItem,
    modifier: Modifier = Modifier
){
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = if (item.completed)
                    Color.Gray
                else
                    MaterialTheme.colorScheme.primaryContainer
        ),
        border = BorderStroke(1.dp, Color.Black),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = modifier.fillMaxWidth().padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Checkbox(
                    checked = item.completed,
                    onCheckedChange = {}
                )
                MyText(
                    awesomeText = AwesomeText.PlainText(item.title),
                    color = MaterialTheme.colorScheme.primary,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleMedium
                        .copy(textDecoration = if (item.completed) TextDecoration.LineThrough else null)
                )
            }
            MyText(
                awesomeText = AwesomeText.PlainText(item.content),
                modifier = modifier.padding(8.dp),
                maxLines = 5,
            )
            MyText(
                awesomeText = AwesomeText.ResourceParams(R.string.created, listOf(item.created.toSimpleFormat("dd-MM-yyyy HH:mm")) ),
                modifier = modifier.fillMaxWidth().padding(end = 8.dp),
                textAlign = TextAlign.Right,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@ThemePreviews
@Composable
fun ToDoNotePreview() {
    MyApplication34568345Theme {
        ToDoNote(
            item = ToDoItem(
                id = 5644,
                title = "Some todo title",
                content = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                        "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown " +
                        "printer took a galley of type and scrambled it to make a type specimen book. " +
                        "It has survived not only five centuries, but also the leap into electronic typesetting, " +
                        "remaining essentially unchanged. It was popularised in the 1960s with the release of " +
                        "Letraset sheets containing Lorem Ipsum passages, and more recently with desktop " +
                        "publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                created = Clock.System.now(),
                completed = false
            )
        )
    }
}

@ThemePreviews
@Composable
fun ToDoNotePreview2() {
    MyApplication34568345Theme {
        ToDoNote(
            item = ToDoItem(
                id = 56,
                title = "Another todo title",
                content = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                        "publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                created = Clock.System.now(),
                completed = true
            )
        )
    }
}