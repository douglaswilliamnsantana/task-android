package com.douglassantana.task.data.local

import com.douglassantana.task.data.local.database.TaskDao
import com.douglassantana.task.data.local.model.TaskEntity

class TaskDatabaseImpl(
    private val taskDao: TaskDao
): TaskDatabase {

    override suspend fun insert(task: TaskEntity) = taskDao.insert(task)

    override suspend fun getAllTasks(): List<TaskEntity> = taskDao.getAllTasks()
}