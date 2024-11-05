package com.example.oech_app.ui.session_2.otpverification

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.oech_app.ui.session_2.newpassword.NewPasswordScreen

class OTPScreen: Screen {

    override val key: ScreenKey = uniqueScreenKey
    private val viewModel = OTPViewModel()

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        val codeText = viewModel.codeText.map { it.collectAsState("") }.map { it.value }

        OTPVerification(
            codeText = codeText,
            onClick = {},
            onValueChange = viewModel::onCodeChange,
            onSetPass = {navigator?.push(NewPasswordScreen())}
        )
    }
}