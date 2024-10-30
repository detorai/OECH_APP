package com.example.oech_app.ui.session_1.onboarding.ob2

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.oech_app.ui.session_1.onboarding.ob3.Onboarding3Screen

class OnBoarding2Screen: Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        OnBoarding2(
            onClickPrimary = {navigator?.push(Onboarding3Screen())},
            onClickSecondly = {navigator?.push(Onboarding3Screen())}
        )
    }
}