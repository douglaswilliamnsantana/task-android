package com.douglassantana.domain.useCase

import com.douglassantana.domain.mapper.toModel
import com.douglassantana.domain.model.TaskModel
import com.douglassantana.local.respository.TaskLocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetTaskUseCase(
    private val taskLocalRepository: TaskLocalRepository
) {

    operator fun invoke(): Flow<List<TaskModel>> = flow {
        emit(taskLocalRepository.getAllTasks().toModel())
    }
}