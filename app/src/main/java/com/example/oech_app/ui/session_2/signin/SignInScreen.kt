package com.example.oech_app.ui.session_2.signin

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.oech_app.ui.session_2.Session2ViewModel
import com.example.oech_app.ui.session_2.forgotpassword.ForgotPasswordScreen
import com.example.oech_app.ui.session_2.home.HomeScreen

class SignInScreen: Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val viewModel = viewModel<Session2ViewModel>()

        val emailText = viewModel.emailText.collectAsState().value
        val passwordText = viewModel.passwordText.collectAsState().value
        val passwordVisible = viewModel.passwordVisible.collectAsState().value
        val checked = viewModel.checked.collectAsState().value
        val allFull = viewModel.isEnabledLogIn
        var regError = viewModel.regError.collectAsState().value
        val userList = viewModel.userList

        SignIn(
            emailText = emailText,
            onEmailChange = viewModel::onEmailChange,

            passwordText = passwordText,
            onPasswordChange = viewModel::onPasswordChange,

            onClickTrailing = viewModel::onPasswordVisible,
            checked = checked,
            onCheckedChange = viewModel::onCheckedChange,
            onSignUp = {navigator?.pop()},
            onLogIn = {
                Log.d("SignInScreen", "Попытка входа с email: $emailText и паролем: $passwordText")
                val user = viewModel.signIn(emailText, passwordText)
                Log.d("SignInScreen", "Результат входа: ${user != null}")
                if (user != null) {
                    navigator?.push(HomeScreen())
                } else {
                    regError = true
                }
            },
            onForgotPass = {navigator?.push(ForgotPasswordScreen())},
            enabled = allFull,
            passVisible = passwordVisible
        )
    }
}