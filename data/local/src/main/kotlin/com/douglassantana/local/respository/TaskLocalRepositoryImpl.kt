package com.douglassantana.local.respository

import com.douglassantana.local.database.TaskDatabase
import com.douglassantana.local.database.model.TaskEntity
import kotlinx.coroutines.flow.Flow

class TaskLocalRepositoryImpl(
    private val taskDatabase: TaskDatabase
) : TaskLocalRepository {

    override suspend fun insert(task: TaskEntity) = taskDatabase.insert(task)

    override fun getAllTasks(): Flow<List<TaskEntity>> = taskDatabase.getAllTasks()
}