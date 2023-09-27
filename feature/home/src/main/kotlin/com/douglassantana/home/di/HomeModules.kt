package com.douglassantana.home.di

import com.douglassantana.home.ui.TaskHomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeViewModelModules = module {
    viewModel {
        TaskHomeViewModel(useCase = get())
    }
}