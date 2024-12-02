package com.example.oech_app.ui.session_4

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.oech_app.common.AppTopBar
import com.example.oech_app.common.BottomTabBar

@Composable
fun Wallet(
    onClickBack: ()-> Unit,
    mainColor: Color,
    secondaryColor: Color,
    textColor: Color,
    onHome: () -> Unit,
    onWallet: () ->Unit,
    onProfile: ()-> Unit,
    selectedTabIndex: Int

){
    Scaffold(
        topBar = { AppTopBar(
            label = "Wallet",
            onClickBack = {onClickBack()},
            secondaryColor = secondaryColor
        ) },
        bottomBar = {
            BottomTabBar(
                textColor = textColor,
                mainColor = mainColor,
                onHome = onHome,
                onWallet = onWallet,
                onTrack = {},
                onProfile = onProfile,
                selectedTabIndex = selectedTabIndex
            )
        }
    )
    {innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ){

        }
    }
}