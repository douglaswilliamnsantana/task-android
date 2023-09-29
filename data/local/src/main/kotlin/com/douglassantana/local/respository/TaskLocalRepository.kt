package com.douglassantana.local.respository

import com.douglassantana.local.database.model.TaskEntity
import kotlinx.coroutines.flow.Flow

interface TaskLocalRepository {

    suspend fun insert(task: TaskEntity)

    fun getAllTasks(): Flow<List<TaskEntity>>
}