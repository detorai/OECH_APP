package com.example.oech_app.ui.session_3.profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.oech_app.ui.session_2.Session2ViewModel
import com.example.oech_app.ui.session_3.add_payment_method.AddPayMethScreen
import com.example.oech_app.ui.session_3.home.HomeScreen
import com.example.oech_app.ui.session_4.WalletScreen
import com.example.session_1.R

class ProfileScreen(private val viewModel: Session2ViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val checked = viewModel.checked.collectAsState().value
        val colors = viewModel.getColors(checked)
        val balance = viewModel.balance.collectAsState().value
        val balanceState = viewModel.balanceState.collectAsState().value

        var selectedTabIndex = viewModel.selectedTabIndex.collectAsState().value



        LaunchedEffect(Unit) {
            viewModel.makeBalance()
            viewModel.changeSelect(4)
        }

        Profile(
            name = "Ken",
            balance = viewModel.hidingBalance(balanceState, balance),
            image = R.drawable.profile_image,
            onCheckChange = viewModel:: onCheckedChange,
            checked = checked,
            mainColor = colors.mainColor,
            secondaryColor = colors.secondaryColor,
            textColor = colors.textColor,
            onClickBalance = viewModel:: onClickBalance,
            onBankClick = { navigator.push(AddPayMethScreen(viewModel)) },
            onHome = {
                selectedTabIndex = 1
                navigator.push(HomeScreen(viewModel))
                     },
            onWallet = {
                viewModel.changeSelect(2)
                navigator.push(WalletScreen(viewModel))
            },
            onProfile = {
                selectedTabIndex = 4
                navigator.push(ProfileScreen(viewModel))
            },
            selectedTabIndex = selectedTabIndex,
            onClickBack = {navigator.pop()}
        )
    }
}