package com.example.oech_app.ui.session_1.onboarding.ob3

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.oech_app.OechAppViewModel
import com.example.oech_app.ui.session_2.signup.SignUpScreen

class Onboarding3Screen: Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val viewModel = viewModel<OechAppViewModel>()

        Onboarding3(
            onClickPrimary = {navigator?.push(SignUpScreen(viewModel))}
        )
    }
}