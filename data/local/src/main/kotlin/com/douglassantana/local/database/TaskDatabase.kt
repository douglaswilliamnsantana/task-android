package com.douglassantana.local.database

import com.douglassantana.local.database.model.TaskEntity

interface TaskDatabase {

    suspend fun insert(task: TaskEntity)

    suspend fun getAllTasks(): List<TaskEntity>
}