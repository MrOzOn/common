package com.mrozon.myapplication34568345.domain.model

import kotlinx.datetime.Instant

data class ToDoItem(
    val id: Long,
    val title: String,
    val content: String,
    val created: Instant,
    val completed: Boolean,
)
