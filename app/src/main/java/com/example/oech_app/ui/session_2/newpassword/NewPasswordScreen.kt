package com.example.oech_app.ui.session_2.newpassword

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.oech_app.ui.session_2.home.HomeScreen

class NewPasswordScreen: Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val passwordText by remember { mutableStateOf("")}
        val repeatPasswordText by remember { mutableStateOf("")}


        NewPassword(
            onClickTrailing1 = {},
            onClickTrailing2 = {},
            passwordText = passwordText,
            repeatPasswordText = repeatPasswordText,
            onPasswordChange = {},
            onRepeatPasswordChange = {},
            onLogIn = {navigator?.push(HomeScreen())}
        )
    }
}