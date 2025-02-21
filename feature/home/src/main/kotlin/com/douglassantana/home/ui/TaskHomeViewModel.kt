package com.douglassantana.home.ui

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.douglassantana.common.ViewerUiResponse
import com.douglassantana.data.respository.TaskLocalRepository
import com.douglassantana.database.model.TaskEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskHomeViewModel @Inject constructor(
    private val repository: TaskLocalRepository
) : ViewModel(), DefaultLifecycleObserver {

    private val _uiState = MutableStateFlow(TaskHomeUiState())
    val uiState: StateFlow<TaskHomeUiState> = _uiState.asStateFlow()

    override fun onCreate(owner: LifecycleOwner) {
        getTasks()
    }

    private fun getTasks() =
        viewModelScope.launch {
            repository.getAllTasks()
                .collect { tasks ->
                    updateScreenStateSuccess(taskModel = tasks)
                }
        }

    private fun updateScreenStateSuccess(taskModel: List<TaskEntity>) {
        _uiState.update { currentState ->
            currentState.copy(
                taskState = ViewerUiResponse.Success(taskModel),
                taskList = taskModel
            )
        }
    }
}