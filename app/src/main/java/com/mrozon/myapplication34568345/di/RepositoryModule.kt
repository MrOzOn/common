package com.mrozon.myapplication34568345.di

import com.mrozon.myapplication34568345.data.db.dao.ToDoItemDao
import com.mrozon.myapplication34568345.data.repository.ToDoItemRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideToDoItemRepo(
        toDoItemDao: ToDoItemDao
    ) = ToDoItemRepo(
        toDoItemDao
    )
}