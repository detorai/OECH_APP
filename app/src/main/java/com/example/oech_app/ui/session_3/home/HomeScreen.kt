package com.example.oech_app.ui.session_3.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.oech_app.OechAppViewModel
import com.example.oech_app.ui.session_3.profile.ProfileScreen
import com.example.oech_app.ui.session_4.tracking_package.TrackingPackageScreen
import com.example.oech_app.ui.session_4.wallet.WalletScreen

class HomeScreen(private val viewModel: OechAppViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val checked = viewModel.checked.collectAsState().value
        val colors = viewModel.getColors(checked)
        val selectedTabIndex = viewModel.selectedTabIndex.collectAsState().value
        val inputText = viewModel.searchText.collectAsState().value

        LaunchedEffect(Unit) {
            viewModel.changeSelect(1)
        }

        Home(
            mainColor = colors.mainColor,
            textColor = colors.textColor,
            onHome = {
                viewModel.changeSelect(1)
                navigator.push(HomeScreen(viewModel))
                     },
            onProfile = {
                viewModel.changeSelect(4)
                navigator.push(ProfileScreen(viewModel))
            },
            onWallet = {
                viewModel.changeSelect(2)
                navigator.push(WalletScreen(viewModel))
            },
            selectedTabIndex = selectedTabIndex,
            onTrack = {
                viewModel.changeSelect(3)
                navigator.push(TrackingPackageScreen(viewModel))
            },
            inputText = inputText,
            onValue = viewModel:: onSearchText
        )
    }
}