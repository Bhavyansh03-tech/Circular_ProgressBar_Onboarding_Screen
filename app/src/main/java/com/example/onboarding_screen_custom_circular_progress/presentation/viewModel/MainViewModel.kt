package com.example.onboarding_screen_custom_circular_progress.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onboarding_screen_custom_circular_progress.domain.useCases.AppEntryUseCases
import com.example.onboarding_screen_custom_circular_progress.presentation.navigation.screenNames.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
) : ViewModel() {

    private val _splashCondition = MutableStateFlow(true)
    val splashCondition: StateFlow<Boolean> = _splashCondition

    private val _startDestination = MutableStateFlow<Screens?>(null)
    val startDestination: StateFlow<Screens?> = _startDestination

    init {
        viewModelScope.launch {
            appEntryUseCases.readAppEntry().onEach { shouldStartFromHomeScreen ->
                _startDestination.value = if (shouldStartFromHomeScreen) Screens.HomeNavigator else Screens.AppStartNavigation
                delay(100)
                _splashCondition.value = false
            }.launchIn(this)
        }
    }
}