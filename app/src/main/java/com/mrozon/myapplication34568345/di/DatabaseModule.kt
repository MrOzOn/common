package com.mrozon.myapplication34568345.di

import android.content.Context
import androidx.room.Room
import com.mrozon.myapplication34568345.data.db.ToDoDatabase
import com.mrozon.myapplication34568345.data.db.ToDoDatabase.Companion.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideToDoItemDao(database: ToDoDatabase) = database.toDoItemDaoDAO()

    @Provides
    @Singleton
    fun providesDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        ToDoDatabase::class.java,
        DB_NAME
    ).build()
}