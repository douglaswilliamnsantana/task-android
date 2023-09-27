package com.douglassantana.register.di

import com.douglassantana.register.ui.TaskRegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val registerViewModelModules = module {
    viewModel {
        TaskRegisterViewModel(useCase = get())
    }
}