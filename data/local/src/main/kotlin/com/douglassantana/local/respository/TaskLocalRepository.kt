package com.douglassantana.local.respository

import com.douglassantana.local.database.model.TaskEntity

interface TaskLocalRepository {

    suspend fun insert(task: TaskEntity)

    suspend fun getAllTasks(): List<TaskEntity>
}