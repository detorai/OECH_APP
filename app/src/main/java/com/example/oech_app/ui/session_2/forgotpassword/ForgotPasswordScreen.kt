package com.example.oech_app.ui.session_2.forgotpassword

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.oech_app.ui.session_2.Session2ViewModel
import com.example.oech_app.ui.session_2.otpverification.OTPScreen

class ForgotPasswordScreen(private val viewModel: Session2ViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val emailText = viewModel.forgotPassEmail.collectAsState().value
        val users = viewModel.userList.collectAsState().value
        var emailError = viewModel.emailError.collectAsState().value


        ForgotPassword(
            emailText = emailText,
            onEmailChange = viewModel:: onForPassEmailChange,
            onSignIn = {navigator?.pop()},
            onSendOTP = {
                when {
                    users.any{it.email != emailText} -> {
                        emailError = true
                    }
                else -> {
                    viewModel.sendOTP(emailText)
                    navigator?.push(OTPScreen(viewModel))
                }
                }
            }
        )
    }
}