package com.example.oech_app.ui.session_3.profile

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.oech_app.common.AppTopBar
import com.example.oech_app.ui.session_2.Session2ViewModel
import com.example.oech_app.ui.session_3.profile.common.ProfileContent
import com.example.oech_app.ui.session_3.tabs.ProfileTab


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
    viewModel: Session2ViewModel
) {
    TabNavigator(ProfileTab(viewModel)){
    Scaffold(
        topBar = {
            AppTopBar(
                label = "Profile",
                onClickBack = {},
                secondaryColor = secondaryColor
            )
        },
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
}