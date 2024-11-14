package com.example.oech_app.ui.session_2.otpverification

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.oech_app.ui.session_2.Session2ViewModel
import com.example.oech_app.ui.session_2.newpassword.NewPasswordScreen

class OTPScreen(private val viewModel: Session2ViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey


    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val codeText = viewModel.codeText.map { it.collectAsState("") }.map { it.value }
        val email = viewModel.emailForChangePass.collectAsState().value
        var field1 = viewModel.otpError.collectAsState().value

        OTPVerification(
            codeText = codeText,
            onClick = {
                    viewModel.sendOTP(email)
            },
            onValueChange = viewModel::onCodeChange,
            onSetPass = {
                when {
                    !viewModel.checkOTP() -> {
                        field1 = true
                    }
                    else -> {
                        field1 = false
                        navigator?.push(NewPasswordScreen(viewModel))
                    }
                }
            },
            field1 = field1
        )
    }
}