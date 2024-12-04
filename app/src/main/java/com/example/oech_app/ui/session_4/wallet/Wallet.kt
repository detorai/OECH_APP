package com.example.oech_app.ui.session_4.wallet

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.oech_app.common.AppTopBar
import com.example.oech_app.common.BottomTabBar
import com.example.oech_app.common.common_s4.WalletProfile

@Composable
fun Wallet(
    onClickBack: ()-> Unit,
    mainColor: Color,
    secondaryColor: Color,
    textColor: Color,
    onHome: () -> Unit,
    onWallet: () ->Unit,
    onProfile: ()-> Unit,
    selectedTabIndex: Int,
    name: String,
    balance: String,
    @DrawableRes image: Int,
    onClickBalance: () -> Unit,
    onBank: ()-> Unit,
    onTransfer: ()-> Unit,
    onCard: ()-> Unit
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
            WalletProfile(
                mainColor = mainColor,
                name = name,
                balance = balance,
                image = image,
                textColor = textColor,
                secondaryColor = secondaryColor,
                onCard = onCard,
                onBank = onBank,
                onTransfer = onTransfer,
                onClickBalance = onClickBalance
            )
        }
    }
}