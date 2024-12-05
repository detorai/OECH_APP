package com.example.oech_app.ui.session_2.signup

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.oech_app.OechAppViewModel
import com.example.oech_app.ui.session_2.signin.SignInScreen

class SignUpScreen(private val viewModel: OechAppViewModel): Screen {

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
        val userList = viewModel.userList.collectAsState().value
        var field1 = viewModel.phoneError.collectAsState().value
        var field2 = viewModel.email1Error.collectAsState().value
        var field3 = viewModel.repPass1Error.collectAsState().value

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
                    userList.any {it.phone == phoneText} -> {
                        field1 = true
                    }
                    !viewModel.checkEmail(emailText) -> {
                        field2 = true
                    }
                    userList.any { it.email == emailText} -> {
                        field2 = true
                    }
                    repPassText != passwordText -> {
                        field3 = true
                    }
                    else -> {
                        Log.d("SignUpScreen", "Попытка регистрации с email: $emailText и паролем: $passwordText")
                        viewModel.signUp(
                            name = nameText,
                            phone = phoneText,
                            email = emailText,
                            password = passwordText
                        )
                        field1 = false
                        field2 = false
                        field3 = false
                        navigator?.push(SignInScreen(viewModel))
                    }
                }
            },
            onSignIn = {navigator?.push(SignInScreen(viewModel))},
            field1 = field1,
            field2 = field2,
            field3 = field3
        )
    }
}