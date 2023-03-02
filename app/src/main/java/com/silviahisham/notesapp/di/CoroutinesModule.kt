package com.silviahisham.notesapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(SingletonComponent::class)
internal class CoroutinesModule {

    @Provides
    fun provideIoContext(): CoroutineContext = Dispatchers.IO
}