package com.douglassantana.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.douglassantana.common.TaskState
import com.douglassantana.domain.mapper.toModel
import com.douglassantana.domain.model.TaskModel
import com.douglassantana.domain.useCase.GetTaskUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class TaskHomeViewModel(
    private val useCase: GetTaskUseCase
) : ViewModel() {

    private val _error = MutableStateFlow(false)
    val error: StateFlow<Boolean> = _error.asStateFlow()

    val uiState: StateFlow<TaskHomeScreenState> =
        useCase.invoke()
            .map {
                updateScreenStateSuccess(it.toModel())
            }
            .catch {
                updateScreenStateError(it)
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = TIMEOUT_MILLIS),
                initialValue = TaskHomeScreenState()
            )


    private fun updateScreenStateSuccess(taskModel: List<TaskModel>) =
        TaskHomeScreenState(
            taskState = TaskState.Complete,
            taskList = taskModel
        )

    private fun updateScreenStateError(exception: Throwable) {
        _error.update { true }
        TaskHomeScreenState(
            taskState = TaskState.Error(exception)
        )
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}