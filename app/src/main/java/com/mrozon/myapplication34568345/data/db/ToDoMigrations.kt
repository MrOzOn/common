package com.mrozon.myapplication34568345.data.db

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("ALTER TABLE todo_table ADD COLUMN `todo_completed` BOOL NOT NULL DEFAULT FALSE")
    }
}