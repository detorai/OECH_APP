package com.example.oech_app.ui.session_2.signup

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
        val value by remember { mutableStateOf("") }
        var checked by remember {mutableStateOf(false)}

        SignUp(
            fnValue = value,
            fnOnChange = {},
            onClickTrailing1 = {},
            onClickTrailing2 = {},
            checked = checked,
            onCheckedChange = { checked = it }
        )
    }
}