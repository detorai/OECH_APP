package com.example.oech_app.ui.session_3.trans_succ

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.oech_app.OechAppViewModel
import com.example.oech_app.ui.session_4.tracking_package.TrackingPackageScreen

class TransSuccScreen(private val viewModel: OechAppViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val trackNum = viewModel.trackNum.collectAsState().value
        val loaded = viewModel.loadedStart.collectAsState().value

        LaunchedEffect(!loaded) {
            viewModel.transSuccessful()
        }

        TransSucc(
            loaded = loaded,
            trackNum = trackNum,
            onBack = {navigator.pop()},
            onTrack = {
                navigator.push(TrackingPackageScreen(viewModel))
            }
        )
    }
}