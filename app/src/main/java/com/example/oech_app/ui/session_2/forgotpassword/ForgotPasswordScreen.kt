package com.example.oech_app.ui.session_2.forgotpassword

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.oech_app.ui.session_2.otpverification.OTPScreen

class ForgotPasswordScreen: Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        var fnValue by remember { mutableStateOf("")}

        ForgotPassword(
            fnValue = fnValue,
            fnOnChange = {fnValue = it},
            onSignIn = {navigator?.pop()},
            onSendOTP = {navigator?.push(OTPScreen())}
        )
    }
}