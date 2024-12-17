package com.example.oech_app.ui.session_4.dev_succ

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

class DevSuccScreen(private val viewModel: OechAppViewModel): Screen {

    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        val loaded = viewModel.loadedEnd.collectAsState().value
        val feedback = viewModel.feedback.collectAsState().value
        val rating = viewModel.rating.collectAsState().value

        LaunchedEffect(Unit) {
            viewModel.transEnd()
        }

        DevSucc(
            loaded = loaded,
            inputText = feedback,
            onValue = viewModel:: addFeedback,
            onDone = { navigator.push(HomeScreen(viewModel)) },
            rating = rating,
            onRatingChange = viewModel::onRating
        )
    }
}