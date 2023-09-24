package com.douglassantana.task.ui.register

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.douglassantana.task.domain.model.TaskModel
import com.douglassantana.task.domain.useCase.GetTaskRegisterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TaskRegisterViewModel(
    private val useCase: GetTaskRegisterUseCase
) : ViewModel() {

    private val _error = MutableStateFlow(false)
    val error: StateFlow<Boolean> = _error.asStateFlow()

    private val _name = MutableStateFlow(TextFieldValue())
    val name = _name.asStateFlow()

    private val _isEnableButton = MutableStateFlow(false)
    val isEnableButton = _isEnableButton.asStateFlow()

    private val task = TaskModel()

    fun onSave() {
        viewModelScope.launch {
            try {
                useCase.invoke(params = task)
            } catch (e: Exception) {
                _error.update { true }
            }
        }
    }

    fun onChangeName(value: TextFieldValue) {
        _isEnableButton.update { value.text.isNotEmpty() }
        this.task.name = value.text
        _name.update { value }
    }
}