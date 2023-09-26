package com.douglassantana.task.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.douglassantana.domain.model.TaskModel
import com.douglassantana.domain.useCase.GetTaskUseCase
import com.douglassantana.task.core.TaskState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

class TaskHomeViewModel(
    private val useCase: GetTaskUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(TaskHomeScreenState())
    val uiState: StateFlow<TaskHomeScreenState> = _uiState.asStateFlow()

    private val _error = MutableStateFlow(false)
    val error: StateFlow<Boolean> = _error.asStateFlow()

    fun getAllTasks() {
        useCase.invoke()
            .onEach {
                updateScreenStateSuccess(it)
            }
            .catch {
                updateScreenStateError(it)
            }.launchIn(viewModelScope)

    }

    private fun updateScreenStateSuccess(taskModel: List<TaskModel>) {
        _uiState.update { currentState ->
            currentState.copy(
                taskState = TaskState.Complete,
                taskList = taskModel
            )
        }
    }

    private fun updateScreenStateError(exception: Throwable) {
        _error.update { true }
        _uiState.update { currentState ->
            currentState.copy(
                taskState = TaskState.Error(exception)
            )
        }
    }
}