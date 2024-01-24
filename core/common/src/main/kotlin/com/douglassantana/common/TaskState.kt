package com.douglassantana.common

sealed class TaskState {
    data object NotStarted : TaskState()
    data object InProgress : TaskState()
    data object Complete : TaskState()
    class Error(val exception: Throwable) : TaskState()
}