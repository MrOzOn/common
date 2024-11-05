package com.mrozon.myapplication34568345.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mrozon.myapplication34568345.data.db.model.ToDoItemDb
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoItemDao {
    @Query("SELECT * FROM todo_table")
    fun getAllToDoItems() : Flow<List<ToDoItemDb>>

    @Insert
    fun insertToDoItem(item: ToDoItemDb): Long

    @Update
    fun updateToDoItem(item: ToDoItemDb)

    @Query("SELECT * FROM todo_table WHERE todo_id=:id")
    fun getToDoItemById(id: Long) : ToDoItemDb

    @Delete
    fun delete(item: ToDoItemDb): Int
}