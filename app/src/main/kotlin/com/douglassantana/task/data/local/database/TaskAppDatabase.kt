package com.douglassantana.task.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.douglassantana.task.common.TaskConstants.DATABASE_NAME
import com.douglassantana.task.data.local.model.TaskEntity

@Database(
    entities = [TaskEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TaskAppDatabase : RoomDatabase() {

    abstract fun taskDao() : TaskDao

    companion object {

        @Volatile
        private var instance: TaskAppDatabase? = null

        fun getDatabase(context: Context): TaskAppDatabase =
            instance ?: synchronized(this) {
                buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(context: Context): TaskAppDatabase {
            return Room
                .databaseBuilder(
                    context = context,
                    klass = TaskAppDatabase::class.java,
                    name = DATABASE_NAME
                )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}