package com.example.oech_app.ui.session_3.trans_succ

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import com.example.oech_app.ui.session_2.Session2ViewModel

class TransSuccScreen(private val viewModel: Session2ViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current

        val trackNum = viewModel.trackNum.collectAsState().value
        val loaded = viewModel.loaded.collectAsState().value

        LaunchedEffect(!loaded) {
            viewModel.transSuccessful()
        }

        TransSucc(
            loaded = loaded,
            trackNum = trackNum,
            onBack = {},
            onTrack = {}
        )
    }
}