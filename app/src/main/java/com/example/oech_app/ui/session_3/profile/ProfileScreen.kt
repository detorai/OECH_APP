package com.example.oech_app.ui.session_3.profile

import androidx.compose.runtime.Composable
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

        val checked = viewModel.checked.value
        val colors = viewModel.getColors(checked)

        Profile(
            name = "Ken",
            balance = "12313",
            image = R.drawable.profile_image,
            onCheckChange = viewModel:: onCheckedChange,
            checked = checked,
            mainColor = colors.mainColor,
            secondaryColor = colors.secondaryColor,
            textColor = colors.textColor
        )
    }
}