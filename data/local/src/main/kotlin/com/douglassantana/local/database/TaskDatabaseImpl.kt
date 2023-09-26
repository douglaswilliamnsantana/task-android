package com.douglassantana.local.database

import com.douglassantana.local.database.dao.TaskDao
import com.douglassantana.local.database.model.TaskEntity

class TaskDatabaseImpl(
    private val taskDao: TaskDao
): TaskDatabase {

    override suspend fun insert(task: TaskEntity) = taskDao.insert(task)

    override suspend fun getAllTasks(): List<TaskEntity> = taskDao.getAllTasks()
}