package com.douglassantana.database.di

import android.content.Context
import androidx.room.Room
import com.douglassantana.database.TaskAppDatabase
import com.douglassantana.database.dao.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal class TaskDatabaseModule {

    @Provides
    @Singleton
    fun providesTaskDatabase(
        @ApplicationContext context: Context,
    ): TaskAppDatabase = Room.databaseBuilder(
        context = context,
        klass = TaskAppDatabase::class.java,
        name = "task-database",
    ).build()

    @Provides
    fun providesTaskDao(
        database: TaskAppDatabase,
    ): TaskDao = database.taskDao()
}