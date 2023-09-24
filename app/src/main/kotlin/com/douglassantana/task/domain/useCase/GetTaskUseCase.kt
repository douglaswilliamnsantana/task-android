package com.douglassantana.task.domain.useCase

import com.douglassantana.task.data.repository.TaskRepository
import com.douglassantana.task.domain.model.TaskModel
import com.douglassantana.task.mapper.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetTaskUseCase(
    private val taskRepository: TaskRepository
) {

    operator fun invoke(): Flow<List<TaskModel>> = flow {
        emit(taskRepository.getAllTasks().toModel())
    }
}