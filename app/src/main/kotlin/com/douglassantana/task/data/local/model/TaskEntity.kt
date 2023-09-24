package com.douglassantana.task.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.douglassantana.task.common.TaskConstants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val uid: Int = 0,

    @ColumnInfo(name = "name")
    var name: String
)