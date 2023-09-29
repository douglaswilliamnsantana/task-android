package com.douglassantana.local.database

import com.douglassantana.local.database.model.TaskEntity
import kotlinx.coroutines.flow.Flow

interface TaskDatabase {

    suspend fun insert(task: TaskEntity)

    fun getAllTasks(): Flow<List<TaskEntity>>
}