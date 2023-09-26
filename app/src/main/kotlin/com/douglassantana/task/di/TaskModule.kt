package com.douglassantana.task.di

import com.douglassantana.task.ui.home.TaskHomeViewModel
import com.douglassantana.task.ui.register.TaskRegisterViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

internal val viewModelModules = module {
    viewModel {
        TaskRegisterViewModel(useCase = get())
    }

    viewModel {
        TaskHomeViewModel(useCase = get())
    }
}