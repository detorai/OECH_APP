package com.example.oech_app.ui.session_3.notification

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.oech_app.ui.session_2.Session2ViewModel

class NotificationScreen(private val viewModel: Session2ViewModel) : Screen {
    override val key: ScreenKey = uniqueScreenKey



    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val colors = viewModel.getColors(viewModel.checked.value)

        Notification(
            onClickBack = {},
            secondaryColor = Color.White
        )
    }
}