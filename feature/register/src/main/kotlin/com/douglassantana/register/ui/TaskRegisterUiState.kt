package com.douglassantana.register.ui

import androidx.compose.ui.text.input.TextFieldValue

data class TaskRegisterUiState(
    val taskTitleText: TextFieldValue = TextFieldValue(text = ""),
    val taskDescriptionText: TextFieldValue = TextFieldValue(text = ""),
    val isEnableButton: Boolean = false
)