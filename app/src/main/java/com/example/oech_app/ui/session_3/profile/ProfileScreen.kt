package com.example.oech_app.ui.session_3.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.oech_app.ui.session_2.Session2ViewModel
import com.example.session_1.R

class ProfileScreen: Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val viewModel = viewModel<Session2ViewModel>()

        var checked = viewModel.checked.value


        Profile(
            name = "Ken",
            balance = "12313",
            image = R.drawable.profile_image,
            onCheckChange = viewModel:: onCheckedChange,
            checked = checked
        )
    }
}