package com.douglassantana.task.di

import com.douglassantana.task.data.local.TaskDatabase
import com.douglassantana.task.data.local.TaskDatabaseImpl
import com.douglassantana.task.data.local.database.TaskAppDatabase
import com.douglassantana.task.data.repository.TaskRepository
import com.douglassantana.task.data.repository.TaskRepositoryImpl
import com.douglassantana.task.domain.useCase.GetTaskRegisterUseCase
import com.douglassantana.task.domain.useCase.GetTaskUseCase
import com.douglassantana.task.ui.home.TaskHomeViewModel
import com.douglassantana.task.ui.register.TaskRegisterViewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

private val repositoryModules = module {
    single<TaskRepository> {
        TaskRepositoryImpl(taskDatabase = get())
    }
}

internal val useCasesModules = module {
    single {
        GetTaskRegisterUseCase(taskRepository = get())
    }

    single {
        GetTaskUseCase(taskRepository = get())
    }
}

internal val viewModelModules = module {
    viewModel {
        TaskRegisterViewModel(useCase = get())
    }

    viewModel {
        TaskHomeViewModel(useCase = get())
    }
}

internal val databaseModules = module {
    single<TaskDatabase> {
        TaskDatabaseImpl(taskDao = get())
    }

    single {
        TaskAppDatabase.getDatabase(context = get()).taskDao()
    }
}

fun getAppModules(): List<Module> =
    listOf(
        repositoryModules,
        viewModelModules,
        useCasesModules,
        databaseModules
    )