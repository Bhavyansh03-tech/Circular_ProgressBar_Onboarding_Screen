package com.example.onboarding_screen_custom_circular_progress.presentation.navigation.navGraph

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.onboarding_screen_custom_circular_progress.presentation.navigation.screenNames.Screens
import com.example.onboarding_screen_custom_circular_progress.presentation.onboarding.OnboardingScreen
import com.example.onboarding_screen_custom_circular_progress.presentation.onboarding.viewModel.OnboardingViewModel

fun NavGraphBuilder.onboardingNavGraph() {
    navigation<Screens.AppStartNavigation>(
        startDestination = Screens.OnboardingScreen
    ){
        composable<Screens.OnboardingScreen>{
            // Initializing the view model :->
            val viewModel = hiltViewModel<OnboardingViewModel>()

            // Calling Onboarding Screen :->
            OnboardingScreen(
                event = viewModel::onEvent
            )
        }
    }
}