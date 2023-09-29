package com.douglassantana.domain.useCase

import com.douglassantana.local.database.model.TaskEntity
import com.douglassantana.local.respository.TaskLocalRepository
import kotlinx.coroutines.flow.Flow

class GetTaskUseCase(
    private val taskLocalRepository: TaskLocalRepository
) {

    operator fun invoke(): Flow<List<TaskEntity>> =
        taskLocalRepository.getAllTasks()
}