package com.example.onboarding_screen_custom_circular_progress.presentation.onboarding.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.onboarding_screen_custom_circular_progress.R
import com.example.onboarding_screen_custom_circular_progress.common.ClippedImage
import com.example.onboarding_screen_custom_circular_progress.presentation.onboarding.dataClass.Page
import com.example.onboarding_screen_custom_circular_progress.util.Dimens.MediumPadding1
import com.example.onboarding_screen_custom_circular_progress.util.Dimens.MediumPadding2

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page
) {

    Column(
        modifier = modifier
    ) {

        // Onboarding Page Image :->
        ClippedImage(
            shapeImageId = R.drawable.onboarding_design,
            contentImageId = page.image
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        // Onboarding Page Title :->
        Text(
            text = page.title,
            modifier = Modifier
                .padding(horizontal = MediumPadding2)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = MaterialTheme.colorScheme.primary
        )

        // Onboarding Page Description :->
        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = MediumPadding2),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }


}