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
import com.example.oech_app.OechAppViewModel

class AddPayMethScreen(private val viewModel: OechAppViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey



    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        val choose = viewModel.choose.collectAsState().value
        val checked = viewModel.checked.collectAsState().value
        val colors = viewModel.getColors(checked)
        val othChoose = viewModel.othChoose.collectAsState().value
        var state1 by remember { mutableStateOf(true)}
        var state2 by remember { mutableStateOf(true)}


        AddPaymentMethod(
            onClickBack = {navigator?.pop()},
            secondaryColor = colors.secondaryColor,
            mainColor = colors.mainColor,
            textColor = colors.textColor,
            choose = choose,
            othChoose = othChoose,
            makeChoose1 = {
                viewModel.changePayMeth(1)
            },
            makeChoose2 = {
                viewModel.changePayMeth(2)
            },
            makeChooseCard1 = {
                viewModel.changeCard(1)
            },
            makeChooseCard2 = {
                viewModel.changeCard(2)
            },
            onDelete1 = { state1 = false },
            onDelete2 = { state2 = false },
            state1 = state1,
            state2 = state2
        )

    }
}