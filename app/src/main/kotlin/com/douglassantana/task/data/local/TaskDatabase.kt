package com.douglassantana.task.data.local

import com.douglassantana.task.data.local.model.TaskEntity

interface TaskDatabase {

    suspend fun insert(task: TaskEntity)

    suspend fun getAllTasks(): List<TaskEntity>
}