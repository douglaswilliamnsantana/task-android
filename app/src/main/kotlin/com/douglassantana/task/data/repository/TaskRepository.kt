package com.douglassantana.task.data.repository

import com.douglassantana.task.data.local.model.TaskEntity

interface TaskRepository {

    suspend fun insert(task: TaskEntity)

    suspend fun getAllTasks(): List<TaskEntity>
}