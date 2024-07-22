package com.example.onboarding_screen_custom_circular_progress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.onboarding_screen_custom_circular_progress.presentation.navigation.navGraph.NavGraph
import com.example.onboarding_screen_custom_circular_progress.presentation.viewModel.MainViewModel
import com.example.onboarding_screen_custom_circular_progress.ui.theme.OnboardingScreenCustomCircularProgressTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.splashCondition
            }
        }

        enableEdgeToEdge()
        setContent {
            OnboardingScreenCustomCircularProgressTheme {
                Box(
                    modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
                ){
                    val startDestination = viewModel.startDestination
                    NavGraph(startDestination = startDestination)
                }
            }
        }
    }
}