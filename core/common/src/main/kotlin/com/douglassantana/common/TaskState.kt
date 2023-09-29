package com.douglassantana.common

sealed class TaskState {
    object NotStarted : TaskState()
    object InProgress : TaskState()
    object Complete : TaskState()
    class Error(val exception: Throwable) : TaskState()
}