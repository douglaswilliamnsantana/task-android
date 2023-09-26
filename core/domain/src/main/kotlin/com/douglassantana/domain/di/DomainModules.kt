package com.douglassantana.domain.di

import com.douglassantana.domain.useCase.GetTaskRegisterUseCase
import com.douglassantana.domain.useCase.GetTaskUseCase
import org.koin.dsl.module

val useCasesModules = module {
    single {
        GetTaskRegisterUseCase(taskLocalRepository = get())
    }

    single {
        GetTaskUseCase(taskLocalRepository = get())
    }
}