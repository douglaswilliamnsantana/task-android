package com.douglassantana.data.di

import com.douglassantana.data.respository.TaskLocalRepository
import com.douglassantana.data.respository.TaskLocalRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsTaskRepository(
        taskLocalRepositoryImpl: TaskLocalRepositoryImpl
    ): TaskLocalRepository

}