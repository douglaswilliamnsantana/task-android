package com.douglassantana.task.data.repository

import com.douglassantana.task.data.local.TaskDatabase
import com.douglassantana.task.data.local.model.TaskEntity

class TaskRepositoryImpl(
    private val taskDatabase: TaskDatabase
) : TaskRepository {

    override suspend fun insert(task: TaskEntity) = taskDatabase.insert(task)

    override suspend fun getAllTasks(): List<TaskEntity> = taskDatabase.getAllTasks()
}