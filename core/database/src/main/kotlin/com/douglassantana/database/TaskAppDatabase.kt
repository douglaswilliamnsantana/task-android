package com.douglassantana.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.douglassantana.database.dao.TaskDao
import com.douglassantana.database.model.TaskEntity
import com.douglassantana.database.util.InstantConverter

const val DATABASE_VERSION = 1

@Database(
    entities = [TaskEntity::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
@TypeConverters(InstantConverter::class,)
abstract class TaskAppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}