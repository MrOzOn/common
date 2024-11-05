package com.mrozon.common.db

import kotlinx.coroutines.flow.Flow

interface ICommonCRUD<T> {
    suspend fun addItem(item: T): T
    suspend fun getItems(): Flow<List<T>>
    suspend fun getItemById(id: Long): T
    suspend fun editItem(item: T)
    suspend fun deleteItem(item: T): Int
}