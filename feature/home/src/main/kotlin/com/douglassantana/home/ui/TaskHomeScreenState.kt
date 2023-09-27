package com.douglassantana.home.ui

import com.douglassantana.common.ScreenState
import com.douglassantana.common.TaskState
import com.douglassantana.domain.model.TaskModel

data class TaskHomeScreenState(
    val taskState: TaskState = TaskState.NotStarted,
    val taskList: List<TaskModel> = listOf()
): ScreenState(taskState)