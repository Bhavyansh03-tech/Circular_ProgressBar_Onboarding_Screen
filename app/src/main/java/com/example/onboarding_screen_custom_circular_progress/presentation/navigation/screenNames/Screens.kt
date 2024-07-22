package com.example.onboarding_screen_custom_circular_progress.presentation.navigation.screenNames

import kotlinx.serialization.Serializable

sealed class Screens {

    @Serializable object HomeScreen
    @Serializable object OnboardingScreen
    @Serializable data object AppStartNavigation : Screens()
    @Serializable data object HomeNavigator : Screens()

}