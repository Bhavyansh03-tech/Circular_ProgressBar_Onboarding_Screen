package com.example.onboarding_screen_custom_circular_progress.domain.useCases

import com.example.onboarding_screen_custom_circular_progress.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager : LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}