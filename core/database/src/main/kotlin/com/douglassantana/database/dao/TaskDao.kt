package com.douglassantana.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.douglassantana.database.model.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task: TaskEntity)

    @Query("SELECT * from tasks ORDER BY title ASC")
    fun getAllTasks(): Flow<List<TaskEntity>>
}