package com.douglassantana.task.base

import android.app.Application
import com.douglassantana.domain.di.useCasesModules
import com.douglassantana.local.database.di.databaseModules
import com.douglassantana.local.database.di.repositoryModules
import com.douglassantana.task.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TaskApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@TaskApplication)
            modules(
                listOf(
                    repositoryModules,
                    viewModelModules,
                    useCasesModules,
                    databaseModules
                )
            )
        }
    }
}