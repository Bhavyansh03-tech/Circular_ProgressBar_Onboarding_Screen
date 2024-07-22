package com.example.onboarding_screen_custom_circular_progress.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {

    suspend fun saveAppEntry()
    fun readAppEntry() : Flow<Boolean>

}