package com.douglassantana.domain.useCase

import com.douglassantana.domain.mapper.toModel
import com.douglassantana.domain.model.TaskModel
import com.douglassantana.local.respository.TaskLocalRepository

class GetTaskRegisterUseCase(
    private val taskLocalRepository: TaskLocalRepository
): UseCase<Unit, TaskModel>() {

    override suspend fun run(params: TaskModel) {
        taskLocalRepository.insert(params.toModel())
    }
}