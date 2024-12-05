package com.example.oech_app.ui.session_2.forgotpassword

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.oech_app.OechAppViewModel
import com.example.oech_app.ui.session_2.otpverification.OTPScreen

class ForgotPasswordScreen(private val viewModel: OechAppViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val emailText = viewModel.forgotPassEmail.collectAsState().value
        val users = viewModel.userList.collectAsState().value
        var field1 = viewModel.email3Error.collectAsState().value


        ForgotPassword(
            emailText = emailText,
            onEmailChange = viewModel:: onForPassEmailChange,
            onSignIn = {navigator?.pop()},
            onSendOTP = {
                when {
                    users.any{it.email != emailText} -> {
                        field1 = true
                    }
                    else -> {
                    viewModel.sendOTP(emailText)
                    field1 = false
                    navigator?.push(OTPScreen(viewModel))
                    }
                }
            },
            field1 = field1
        )
    }
}