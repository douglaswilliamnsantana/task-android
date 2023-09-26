package com.douglassantana.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.douglassantana.local.database.model.TaskEntity

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task: TaskEntity)

    @Query("SELECT * from tasks ORDER BY name ASC")
    fun getAllTasks(): List<TaskEntity>
}