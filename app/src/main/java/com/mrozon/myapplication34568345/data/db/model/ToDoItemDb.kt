package com.mrozon.myapplication34568345.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mrozon.myapplication34568345.domain.model.ToDoItem
import kotlinx.datetime.Instant

@Entity(tableName = "todo_table")
data class ToDoItemDb(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "todo_id")
    val id: Long,

    @ColumnInfo(name = "todo_title")
    val title: String,

    @ColumnInfo(name = "todo_content")
    val content: String,

    @ColumnInfo(name = "todo_created")
    val created: Long,
)


fun ToDoItemDb.toDomain() = ToDoItem(
    id = this.id,
    title = this.title,
    content = this.content,
    created = Instant.fromEpochMilliseconds(this.created)
)