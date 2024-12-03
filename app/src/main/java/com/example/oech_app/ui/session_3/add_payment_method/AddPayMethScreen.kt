package com.example.oech_app.ui.session_3.add_payment_method

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

class AddPayMethScreen(private val viewModel: Session2ViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey



    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        var choose by remember { mutableStateOf(false)}
        var othChoose by remember { mutableStateOf(false)}
        val checked = viewModel.checked.collectAsState().value
        val colors = viewModel.getColors(checked)


        AddPaymentMethod(
            onClickBack = {navigator?.pop()},
            secondaryColor = colors.secondaryColor,
            mainColor = colors.mainColor,
            textColor = colors.textColor,
            choose = choose,
            othChoose = othChoose,
            makeChoose1 = {
                choose = !choose
            },
            makeChoose2 = {
                othChoose = !othChoose
            }
        )
    }
}