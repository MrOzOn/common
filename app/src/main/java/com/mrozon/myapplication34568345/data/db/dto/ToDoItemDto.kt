package com.mrozon.myapplication34568345.data.db.dto

import com.mrozon.myapplication34568345.data.db.model.ToDoItemDb
import com.mrozon.myapplication34568345.domain.model.ToDoItem
import kotlinx.datetime.Instant


fun ToDoItemDb.toDomain() = ToDoItem(
    id = this.id,
    title = this.title,
    content = this.content,
    created = Instant.fromEpochMilliseconds(this.created)
)

fun ToDoItem.toDb() = ToDoItemDb(
    id = this.id,
    title = this.title,
    content = this.content,
    created = this.created.toEpochMilliseconds()
)