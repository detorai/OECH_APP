package com.example.oech_app.ui.session_2.signup

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.oech_app.ui.session_2.Session2ViewModel
import com.example.oech_app.ui.session_2.signin.SignInScreen

class SignUpScreen: Screen {

    override val key: ScreenKey = uniqueScreenKey
    private val viewModel = Session2ViewModel()

    @SuppressLint("UnrememberedMutableState")
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        val nameText = viewModel.nameText.collectAsState().value
        val phoneText = viewModel.phoneText.collectAsState().value
        val emailText = viewModel.emailText.collectAsState().value
        val passwordText = viewModel.passwordText.collectAsState().value
        val repPassText = viewModel.repeatPasswordText.collectAsState().value
        val checked = viewModel.checked.collectAsState().value

        SignUp(
            nameText = nameText,
            onNameChange = viewModel:: onNameChange,
            phoneText = phoneText,
            onPhoneChange = viewModel:: onPhoneChange,
            emailText = emailText,
            onEmailChange = viewModel:: onEmailChange,
            passwordText = passwordText,
            onPasswordChange = viewModel:: onPasswordChange,
            repeatPasswordText = repPassText,
            onRepPasswordChange = viewModel:: onRepPasswordChange,
            onClickTrailing1 = {},
            onClickTrailing2 = {},
            checked = checked,
            onCheckedChange = viewModel::onCheckedChange,
            onSignUp = { if (checked)
                { navigator?.push(SignInScreen()) }
                       },
            onSignIn = {navigator?.push(SignInScreen())}
        )
    }
}