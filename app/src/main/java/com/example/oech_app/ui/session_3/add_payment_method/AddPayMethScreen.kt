package com.example.oech_app.ui.session_3.add_payment_method

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.oech_app.ui.session_2.Session2ViewModel

class AddPayMethScreen(private val viewModel: Session2ViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey



    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        val colors = viewModel.getColors(viewModel.checked.value)


        AddPaymentMethod(
            onClickBack = {navigator?.pop()},
            secondaryColor = colors.secondaryColor
        )
    }
}