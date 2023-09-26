package com.douglassantana.task.ui.home

import com.douglassantana.domain.model.TaskModel
import com.douglassantana.task.core.ScreenState
import com.douglassantana.task.core.TaskState

data class TaskHomeScreenState(
    val taskState: TaskState = TaskState.NotStarted,
    val taskList: List<TaskModel> = listOf()
): ScreenState(taskState)