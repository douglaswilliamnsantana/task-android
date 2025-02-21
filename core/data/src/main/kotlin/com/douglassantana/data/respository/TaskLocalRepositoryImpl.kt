package com.douglassantana.data.respository

import com.douglassantana.database.dao.TaskDao
import com.douglassantana.database.model.TaskEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskLocalRepositoryImpl @Inject constructor(
    private val taskDao: TaskDao
) : TaskLocalRepository {

    override suspend fun insert(task: TaskEntity) = taskDao.insert(task = task)

    override fun getAllTasks(): Flow<List<TaskEntity>> = taskDao.getAllTasks()
}