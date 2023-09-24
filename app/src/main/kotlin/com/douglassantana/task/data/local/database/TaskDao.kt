package com.douglassantana.task.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.douglassantana.task.data.local.model.TaskEntity

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task: TaskEntity)

    @Query("SELECT * from tasks ORDER BY name ASC")
    fun getAllTasks(): List<TaskEntity>
}