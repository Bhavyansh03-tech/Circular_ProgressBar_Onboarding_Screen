package com.example.onboarding_screen_custom_circular_progress.di

import android.app.Application
import com.example.onboarding_screen_custom_circular_progress.data.manager.LocalUserManagerImpl
import com.example.onboarding_screen_custom_circular_progress.domain.manager.LocalUserManager
import com.example.onboarding_screen_custom_circular_progress.domain.useCases.AppEntryUseCases
import com.example.onboarding_screen_custom_circular_progress.domain.useCases.ReadAppEntry
import com.example.onboarding_screen_custom_circular_progress.domain.useCases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ) : LocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) : AppEntryUseCases = AppEntryUseCases(
        saveAppEntry = SaveAppEntry(localUserManager),
        readAppEntry = ReadAppEntry(localUserManager)
    )
}