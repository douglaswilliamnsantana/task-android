package com.douglassantana.local.database.di

import com.douglassantana.local.database.TaskAppDatabase
import com.douglassantana.local.database.TaskDatabase
import com.douglassantana.local.database.TaskDatabaseImpl
import com.douglassantana.local.respository.TaskLocalRepository
import com.douglassantana.local.respository.TaskLocalRepositoryImpl
import org.koin.dsl.module

val databaseModules = module {
    single<TaskDatabase> {
        TaskDatabaseImpl(taskDao = get())
    }

    single {
        TaskAppDatabase.getDatabase(context = get()).taskDao()
    }
}

val repositoryModules = module {
    single<TaskLocalRepository> {
        TaskLocalRepositoryImpl(taskDatabase = get())
    }
}