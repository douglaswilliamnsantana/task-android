package com.douglassantana.task.ui.home

import com.douglassantana.task.core.ScreenState
import com.douglassantana.task.core.TaskState
import com.douglassantana.task.domain.model.TaskModel

data class TaskHomeScreenState(
    val taskState: TaskState = TaskState.NotStarted,
    val taskList: List<TaskModel> = listOf()
): ScreenState(taskState)