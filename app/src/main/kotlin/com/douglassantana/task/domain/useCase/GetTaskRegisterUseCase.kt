package com.douglassantana.task.domain.useCase

import com.douglassantana.task.data.repository.TaskRepository
import com.douglassantana.task.domain.model.TaskModel
import com.douglassantana.task.mapper.toModel

class GetTaskRegisterUseCase(
    private val taskRepository: TaskRepository
): UseCase<Unit, TaskModel>() {

    override suspend fun run(params: TaskModel) {
        taskRepository.insert(params.toModel())
    }
}