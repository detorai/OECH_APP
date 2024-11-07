package com.example.oech_app.ui.session_2.signup

import androidx.lifecycle.viewmodel.compose.viewModel
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.oech_app.ui.session_2.Session2ViewModel
import com.example.oech_app.ui.session_2.signin.SignInScreen

class SignUpScreen: Screen {

    override val key: ScreenKey = uniqueScreenKey

    @SuppressLint("UnrememberedMutableState")
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val viewModel = viewModel<Session2ViewModel>()

        val nameText = viewModel.nameText.collectAsState().value
        val phoneText = viewModel.phoneText.collectAsState().value
        val emailText = viewModel.emailText.collectAsState().value
        val passwordText = viewModel.passwordText.collectAsState().value
        val passVisible = viewModel.passwordVisible.collectAsState().value
        val repPassVisible = viewModel.repPasswordVisible.collectAsState().value
        val repPassText = viewModel.repeatPasswordText.collectAsState().value
        val checked = viewModel.checked.collectAsState().value
        val allFull = viewModel.isEnabledSignUp
        var regError = viewModel.regError.collectAsState().value
        val userList = viewModel.userList

        SignUp(
            nameText = nameText,
            onNameChange = viewModel:: onNameChange,

            phoneText = phoneText,
            onPhoneChange = viewModel:: onPhoneChange,

            emailText = emailText,
            onEmailChange = viewModel:: onEmailChange,

            passwordText = passwordText,
            onPasswordChange = viewModel:: onPasswordChange,
            onClickTrailing1 = viewModel:: onPasswordVisible,
            passVisible = passVisible,

            repeatPasswordText = repPassText,
            onRepPasswordChange = viewModel:: onRepPasswordChange,
            onClickTrailing2 = viewModel:: onRepPasswordVisible,
            repPassVisible = repPassVisible,

            checked = checked,
            onCheckedChange = viewModel::onCheckedChange,

            allFull = allFull,

            onSignUp = {
                when {
                    !viewModel.checkEmail(emailText) -> {
                        regError = true
                    }

                    repPassText != passwordText -> {
                        regError = true
                    }
                    userList.value.any { it.email == emailText} -> {
                        regError = true
                    }
                    else -> {
                        Log.d("SignUpScreen", "Попытка регистрации с email: $emailText и паролем: $passwordText")
                        viewModel.signUp()
                        navigator?.push(SignInScreen())
                    }
                }
            },
            onSignIn = {navigator?.push(SignInScreen())},
        )
    }
}