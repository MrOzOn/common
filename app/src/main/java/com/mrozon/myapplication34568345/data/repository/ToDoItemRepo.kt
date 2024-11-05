package com.mrozon.myapplication34568345.data.repository

import com.mrozon.myapplication34568345.data.db.dao.ToDoItemDao
import com.mrozon.myapplication34568345.data.db.dto.toDb
import com.mrozon.myapplication34568345.data.db.dto.toDomain
import com.mrozon.myapplication34568345.domain.model.ToDoItem
import com.mrozon.myapplication34568345.domain.repository.IToDoItemRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ToDoItemRepo @Inject constructor(
    private val toDoItemDao: ToDoItemDao
): IToDoItemRepo{

    override suspend fun addItem(item: ToDoItem): ToDoItem {
        val newId = toDoItemDao.insertToDoItem(item.toDb())
        return toDoItemDao.getToDoItemById(newId).toDomain()
    }

    override suspend fun getItems(): Flow<List<ToDoItem>> =
        toDoItemDao.getAllToDoItems().map { items -> items.map { it.toDomain() }.toList() }

    override suspend fun getItemById(id: Long): ToDoItem =
        toDoItemDao.getToDoItemById(id).toDomain()


    override suspend fun editItem(item: ToDoItem) {
        toDoItemDao.updateToDoItem(item.toDb())
    }

    override suspend fun deleteItem(item: ToDoItem): Int =
        toDoItemDao.delete(item.toDb())


}