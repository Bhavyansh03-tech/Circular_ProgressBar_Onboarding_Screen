package com.example.onboarding_screen_custom_circular_progress.domain.useCases

import com.example.onboarding_screen_custom_circular_progress.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {
    operator fun invoke() : Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}