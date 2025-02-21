package com.douglassantana.home.ui

import com.douglassantana.common.ViewerUiResponse
import com.douglassantana.database.model.TaskEntity

data class TaskHomeUiState(
    val taskState: ViewerUiResponse<*> = ViewerUiResponse.Loading(isLoad = true),
    val taskList: List<TaskEntity> = listOf(),
)