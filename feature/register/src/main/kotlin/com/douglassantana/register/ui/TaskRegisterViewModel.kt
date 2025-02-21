package com.douglassantana.register.ui

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.douglassantana.common.isNotNullOrEmpty
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
class TaskRegisterViewModel @Inject constructor(
    private val repository: TaskLocalRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(TaskRegisterUiState())
    val uiState: StateFlow<TaskRegisterUiState> = _uiState.asStateFlow()

    fun createTask() =
        viewModelScope.launch {
            repository.insert(
                task = TaskEntity(
                    title = uiState.value.taskTitleText.text,
                    description = uiState.value.taskDescriptionText.text
                )
            )
        }

    fun updateTaskTitle(taskTitleText: TextFieldValue) {
        _uiState.update { currentState ->
            currentState.copy(
                taskTitleText = taskTitleText,
                isEnableButton = taskTitleText.text.isNotNullOrEmpty()
            )
        }
    }

    fun updateTaskDescription(taskDescriptionText: TextFieldValue) {
        _uiState.update { currentState ->
            currentState.copy(taskDescriptionText = taskDescriptionText)
        }
    }
}