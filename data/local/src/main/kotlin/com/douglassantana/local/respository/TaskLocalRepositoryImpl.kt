package com.douglassantana.local.respository

import com.douglassantana.local.database.TaskDatabase
import com.douglassantana.local.database.model.TaskEntity

class TaskLocalRepositoryImpl(
    private val taskDatabase: TaskDatabase
) : TaskLocalRepository {

    override suspend fun insert(task: TaskEntity) = taskDatabase.insert(task)

    override suspend fun getAllTasks(): List<TaskEntity> = taskDatabase.getAllTasks()
}