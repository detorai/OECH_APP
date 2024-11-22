package com.example.oech_app.ui.session_3.profile

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.common.AppTopBar
import com.example.oech_app.ui.session_3.profile.common.ProfileContent
import com.example.oech_app.ui.theme.Gray


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
    onBankClick: () -> Unit
) {
    Scaffold(
        topBar = {
            AppTopBar(
                label = "Profile",
                onClickBack = {},
                secondaryColor = secondaryColor
            )
        }
    ) {innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        )
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