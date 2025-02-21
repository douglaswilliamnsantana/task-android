package com.douglassantana.data.respository

import com.douglassantana.database.model.TaskEntity
import kotlinx.coroutines.flow.Flow

interface TaskLocalRepository {

    suspend fun insert(task: TaskEntity)

    fun getAllTasks(): Flow<List<TaskEntity>>
}