package com.example.oech_app.ui.session_2.signin

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.oech_app.ui.session_2.Session2ViewModel
import com.example.oech_app.ui.session_2.forgotpassword.ForgotPasswordScreen
import com.example.oech_app.ui.session_2.home.HomeScreen

class SignInScreen(private val viewModel: Session2ViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        val emailText = viewModel.logInEmail.collectAsState().value
        val passwordText = viewModel.passwordSignIn.collectAsState().value
        val passwordVisible = viewModel.passwordSIVisible.collectAsState().value
        val checked = viewModel.checkedSI.collectAsState().value
        val allFull = viewModel.isEnabledLogIn
        var regError = viewModel.regError.collectAsState().value
        val userList = viewModel.userList.collectAsState().value

        SignIn(
            emailText = emailText,
            onEmailChange = viewModel::onLogInEmailChange,

            passwordText = passwordText,
            onPasswordChange = viewModel::onPasswordSIChange,

            onClickTrailing = viewModel::onPasswordSIVisible,
            checked = checked,
            onCheckedChange = viewModel::onCheckedSIChange,
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
            onForgotPass = {navigator?.push(ForgotPasswordScreen(viewModel))},
            enabled = allFull,
            passVisible = passwordVisible
        )
    }
}