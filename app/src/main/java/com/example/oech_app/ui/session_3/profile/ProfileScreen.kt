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
import com.example.oech_app.ui.session_3.add_payment_method.AddPayMethScreen
import com.example.oech_app.ui.session_3.add_payment_method.AddPaymentMethod
import com.example.session_1.R
import kotlinx.coroutines.newSingleThreadContext

class ProfileScreen(): Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val viewModel = viewModel<Session2ViewModel>()

        val checked = viewModel.checked.value
        val colors = viewModel.getColors(checked)
        val balance by remember { mutableStateOf("1328415")}
        var onClickBalance by remember { mutableStateOf(false)}
        val hideBalance = "*****"

        fun hidingBalance(state: Boolean, balance: String, hideBalance: String): String{

            var myBalance = ""

            myBalance = if (!state){
                balance
            } else {
                hideBalance
            }
            return myBalance
        }


        Profile(
            name = "Ken",
            balance = hidingBalance(onClickBalance, balance, hideBalance),
            image = R.drawable.profile_image,
            onCheckChange = viewModel:: onCheckedChange,
            checked = checked,
            mainColor = colors.mainColor,
            secondaryColor = colors.secondaryColor,
            textColor = colors.textColor,
            onClickBalance = {
                onClickBalance = !onClickBalance
            },
            onBankClick = {navigator?.push(AddPayMethScreen(viewModel))}
        )
    }
}