package com.mrozon.myapplication34568345.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mrozon.myapplication34568345.data.db.dao.ToDoItemDao
import com.mrozon.myapplication34568345.data.db.model.ToDoItemDb


@Database(entities = [ToDoItemDb::class], version = 1)
abstract class ToDoDatabase: RoomDatabase(){
    abstract fun toDoItemDaoDAO(): ToDoItemDao

    companion object {
        const val DB_NAME = "to-do-db"
    }
}

