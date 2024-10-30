package com.example.oech_app.ui.session_2.signup

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator

class SignUpScreen: Screen {

    override val key: ScreenKey = uniqueScreenKey

    @SuppressLint("UnrememberedMutableState")
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val value = mutableStateOf("")

        SignUp(
            fnValue = value.value,
            fnOnChange = {}
        )
    }
}