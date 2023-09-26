package com.douglassantana.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.douglassantana.local.database.dao.TaskDao
import com.douglassantana.local.database.model.TaskEntity

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
                    name = "task"
                )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}