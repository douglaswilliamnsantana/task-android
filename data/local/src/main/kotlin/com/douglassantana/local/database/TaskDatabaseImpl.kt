package com.douglassantana.local.database

import com.douglassantana.local.database.dao.TaskDao
import com.douglassantana.local.database.model.TaskEntity
import kotlinx.coroutines.flow.Flow

class TaskDatabaseImpl(
    private val taskDao: TaskDao
): TaskDatabase {

    override suspend fun insert(task: TaskEntity) = taskDao.insert(task)

    override fun getAllTasks(): Flow<List<TaskEntity>> = taskDao.getAllTasks()
}