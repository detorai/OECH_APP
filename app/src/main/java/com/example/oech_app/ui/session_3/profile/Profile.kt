package com.example.oech_app.ui.session_3.profile

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.oech_app.common.AppTopBar
import com.example.oech_app.common.BottomTabBar
import com.example.oech_app.common.common_profile.ProfileContent


@Composable
fun Profile(
    @DrawableRes image: Int,
    balance: String,
    name: String,
    checked: Boolean,
    onCheckChange: (Boolean) -> Unit,
    mainColor: Color,
    secondaryColor: Color,
    textColor: Color,
    onClickBalance: () -> Unit,
    onBankClick: () -> Unit,
    onHome: ()-> Unit,
    onProfile: ()-> Unit,
    selectedTabIndex: Int,
    onWallet: ()-> Unit,
    onClickBack: () -> Unit
) {
    Scaffold(
        topBar = {
            AppTopBar(
                label = "Profile",
                onClickBack = onClickBack,
                secondaryColor = secondaryColor
            )
        },
        bottomBar = {
            BottomTabBar(
                mainColor = mainColor,
                textColor = textColor,
                onProfile = onProfile,
                onHome = onHome,
                onTrack = {},
                onWallet = onWallet,
                selectedTabIndex = selectedTabIndex
            )
        }
    ) {innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            ProfileContent(
                name = name,
                balance = balance,
                image = image,
                checked = checked,
                onCheckChange = onCheckChange,
                mainColor = mainColor,
                secondaryColor = secondaryColor,
                textColor = textColor,
                onClickBalance = onClickBalance,
                onBankClick = onBankClick
            )
        }
    }
}
