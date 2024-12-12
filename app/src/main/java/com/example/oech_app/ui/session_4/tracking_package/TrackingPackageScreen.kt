package com.example.oech_app.ui.session_4.tracking_package

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.oech_app.OechAppViewModel
import com.example.oech_app.ui.session_3.home.HomeScreen
import com.example.oech_app.ui.session_3.profile.ProfileScreen
import com.example.oech_app.ui.session_4.wallet.WalletScreen

class TrackingPackageScreen(private val viewModel: OechAppViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey


    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        val trackNum = viewModel.trackNum.collectAsState().value
        val state1 = viewModel.trackState1.collectAsState().value
        val state2 = viewModel.trackState2.collectAsState().value
        val state3 = viewModel.trackState3.collectAsState().value
        val state4 = viewModel.trackState4.collectAsState().value
        val checked = viewModel.checked.collectAsState().value
        val colors = viewModel.getColors(checked)
        val selectedTabIndex = viewModel.selectedTabIndex.collectAsState().value


        LaunchedEffect(Unit) {
            viewModel.changeSelect(3)
        }

        TrackingPackage(
            trackNum = trackNum,
            state1 = state1,
            onState1 = viewModel::onTrackState1,
            state2 = state2,
            onState2 = viewModel::onTrackState2,
            state3 = state3,
            onState3 = viewModel::onTrackState3,
            state4 = state4,
            onState4 = viewModel::onTrackState4,
            textColor = colors.textColor,
            mainColor = colors.mainColor,
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
            onPackInfo = {
            }
        )
    }
}