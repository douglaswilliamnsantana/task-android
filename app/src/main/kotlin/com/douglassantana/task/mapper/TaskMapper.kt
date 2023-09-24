package com.douglassantana.task.mapper

import com.douglassantana.task.data.local.model.TaskEntity
import com.douglassantana.task.domain.model.TaskModel

fun TaskModel.toModel(): TaskEntity =
    TaskEntity(
        uid = this.uid,
        name = this.name
    )

fun List<TaskEntity>.toModel(): List<TaskModel> =
    this.map {
        TaskModel(
            uid = it.uid,
            name = it.name
        )
    }