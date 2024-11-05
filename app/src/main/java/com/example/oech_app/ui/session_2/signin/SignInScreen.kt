package com.example.oech_app.ui.session_2.signin

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.oech_app.ui.session_2.forgotpassword.ForgotPasswordScreen
import com.example.oech_app.ui.session_2.home.HomeScreen

class SignInScreen: Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        val fnValue by remember { mutableStateOf("") }
        var checked by remember { mutableStateOf(false ) }

        SignIn(
            fnValue = fnValue,
            fnOnChange = {},
            onClickTrailing = {},
            checked = checked,
            onCheckedChange = {checked = it},
            onSignUp = {navigator?.pop()},
            onLogIn = {navigator?.push(HomeScreen())},
            onForPass = {navigator?.push(ForgotPasswordScreen())}
        )
    }
}