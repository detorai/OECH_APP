package com.example.oech_app.ui.session_4.wallet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.oech_app.ui.session_2.Session2ViewModel
import com.example.oech_app.ui.session_3.home.HomeScreen
import com.example.oech_app.ui.session_3.profile.ProfileScreen
import com.example.session_1.R

class WalletScreen(private val viewModel: Session2ViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val checked = viewModel.checked.collectAsState().value
        val colors = viewModel.getColors(checked)
        val selectedTabIndex = viewModel.selectedTabIndex.collectAsState().value
        val balance = viewModel.balance.collectAsState().value
        val name = "Kez"
        val balanceState = viewModel.balanceState.collectAsState().value


        LaunchedEffect(Unit) {
            viewModel.changeSelect(2)
        }

        Wallet(
            mainColor = colors.mainColor,
            secondaryColor = colors.secondaryColor,
            textColor = colors.textColor,
            onClickBack = {navigator.pop()},
            onHome = {
                viewModel.changeSelect(1)
                navigator.push(HomeScreen(viewModel))
            },
            onWallet = {
                viewModel.changeSelect(2)
                navigator.push(WalletScreen(viewModel))
            },
            onProfile = {
                viewModel.changeSelect(4)
                navigator.push(ProfileScreen(viewModel))
            },
            selectedTabIndex = selectedTabIndex,
            name = name,
            balance = viewModel.hidingBalance(balanceState, balance),
            image = R.drawable.profile_image,
            onCard = {},
            onBank = {},
            onTransfer = {},
            onClickBalance =  viewModel::onClickBalance
        )
    }
}