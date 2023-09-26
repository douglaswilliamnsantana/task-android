package com.douglassantana.domain.mapper

import com.douglassantana.domain.model.TaskModel
import com.douglassantana.local.database.model.TaskEntity

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