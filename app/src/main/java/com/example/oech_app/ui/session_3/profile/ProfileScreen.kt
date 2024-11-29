package com.example.oech_app.ui.session_3.profile

import android.util.Log
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
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.oech_app.ui.session_2.Session2ViewModel
import com.example.oech_app.ui.session_3.add_payment_method.AddPayMethScreen
import com.example.session_1.R

class ProfileScreen(private val viewModel: Session2ViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow.parent

        val checked = viewModel.checked.collectAsState().value
        val colors = viewModel.getColors(checked)
        val balance by remember { mutableStateOf("1328415")}
        var onClickBalance by remember { mutableStateOf(false)}
        val hideBalance = "*****"
        var tabState = viewModel.tabState.collectAsState().value

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
            onBankClick = {
                tabState = false
                navigator?.push(AddPayMethScreen(viewModel))
                Log.d("Tab State", "tabState:${tabState}")
                          },
            viewModel = viewModel
        )
    }
}