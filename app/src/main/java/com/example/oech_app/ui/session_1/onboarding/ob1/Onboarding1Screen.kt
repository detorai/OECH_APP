package com.example.oech_app.ui.session_1.onboarding.ob1

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.oech_app.ui.session_1.onboarding.ob2.OnBoarding2Screen
import com.example.oech_app.ui.session_1.onboarding.ob3.Onboarding3Screen

class Onboarding1Screen: Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        Onboarding(
            onClickPrimary = {navigator?.push(OnBoarding2Screen())},
            onClickSecondly = {navigator?.push(Onboarding3Screen())}
        )
    }
}