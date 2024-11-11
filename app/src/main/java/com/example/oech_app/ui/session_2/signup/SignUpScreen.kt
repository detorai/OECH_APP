package com.example.oech_app.ui.session_2.signup

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

class SignUpScreen(private val viewModel: Session2ViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey

    @SuppressLint("UnrememberedMutableState")
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        val nameText = viewModel.nameText.collectAsState().value
        val phoneText = viewModel.phoneText.collectAsState().value
        val emailText = viewModel.signUpEmail.collectAsState().value
        val passwordText = viewModel.passwordSignUp.collectAsState().value
        val passVisible = viewModel.passwordSUVisible.collectAsState().value
        val repPassVisible = viewModel.repPasswordSUVisible.collectAsState().value
        val repPassText = viewModel.repeatPasswordSU.collectAsState().value
        val checked = viewModel.checkedSU.collectAsState().value
        val allFull = viewModel.isEnabledSignUp
        var regError = viewModel.regError.collectAsState().value
        val userList = viewModel.userList.collectAsState().value

        SignUp(
            nameText = nameText,
            onNameChange = viewModel:: onNameChange,

            phoneText = phoneText,
            onPhoneChange = viewModel:: onPhoneChange,

            emailText = emailText,
            onEmailChange = viewModel:: onSUEmailChange,

            passwordText = passwordText,
            onPasswordChange = viewModel:: onPasswordSUChange,
            onClickTrailing1 = viewModel:: onPasswordSUVisible,
            passVisible = passVisible,

            repeatPasswordText = repPassText,
            onRepPasswordChange = viewModel:: onRepPasswordSUChange,
            onClickTrailing2 = viewModel:: onRepPasswordSUVisible,
            repPassVisible = repPassVisible,

            checked = checked,
            onCheckedChange = viewModel::onCheckedSUChange,

            allFull = allFull,

            onSignUp = {
                when {
                    !viewModel.checkEmail(emailText) -> {
                        regError = true
                    }

                    repPassText != passwordText -> {
                        regError = true
                    }
                    userList.any { it.email == emailText} -> {
                        regError = true
                    }
                    else -> {
                        Log.d("SignUpScreen", "Попытка регистрации с email: $emailText и паролем: $passwordText")
                        viewModel.signUp(
                            name = nameText,
                            phone = phoneText,
                            email = emailText,
                            password = passwordText
                        )
                        navigator?.push(SignInScreen(viewModel))
                    }
                }
            },
            onSignIn = {navigator?.push(SignInScreen(viewModel))},
        )
    }
}