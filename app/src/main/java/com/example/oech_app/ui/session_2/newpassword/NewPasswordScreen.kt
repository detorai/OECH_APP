package com.example.oech_app.ui.session_2.newpassword

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.oech_app.ui.session_2.Session2ViewModel
import com.example.oech_app.ui.session_2.home.HomeScreen

class NewPasswordScreen(private val viewModel: Session2ViewModel): Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val passwordText = viewModel.passwordNew.collectAsState().value
        val repeatPasswordText = viewModel.repeatPasswordNew.collectAsState().value
        val repPassVisible = viewModel.repPasswordNewVisible.collectAsState().value
        val passVisible = viewModel.passwordNewVisible.collectAsState().value
        val allFull = viewModel.isEnabledNewPass
        var newPassError = viewModel.newPassError.collectAsState().value
        val emailForChangePass = viewModel.emailForChangePass.collectAsState().value

        NewPassword(
            passwordText = passwordText,
            onPasswordChange = viewModel:: onPasswordNewChange,
            passVisible = passVisible,
            onClickTrailing1 = viewModel:: onPasswordNewVisible,

            repeatPasswordText = repeatPasswordText,
            onRepeatPasswordChange = viewModel:: onRepPasswordNewChange,
            repPassVisible = repPassVisible,
            onClickTrailing2 = viewModel:: onRepPasswordNewVisible,

            allFull = allFull,

            onLogIn = {
                when {
                    passwordText != repeatPasswordText -> {
                        newPassError = true
                    }
                    else -> {
                        Log.d("Email For Change", "Email: $emailForChangePass")
                        viewModel.changePass(emailForChangePass, passwordText)
                        navigator?.push(HomeScreen())
                    }
                }
            }
        )
    }
}