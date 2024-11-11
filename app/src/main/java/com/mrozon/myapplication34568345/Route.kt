package com.mrozon.myapplication34568345

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object ListToDo : Route

    @Serializable
    data class DetailToDo(val id: Long): Route
}