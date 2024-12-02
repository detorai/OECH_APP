package com.example.oech_app.common.common_s4

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.oech_app.common.common_profile.NameAndImage
import com.example.session_1.R

@Composable
fun WalletProfile(
    mainColor: Color,
    secondaryColor: Color,
    textColor: Color,
    name: String,
    balance: String,
    @DrawableRes image: Int,
    onClickBalance: () -> Unit,
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().fillMaxHeight().background(mainColor).padding(25.dp, 25.dp, 25.dp, 0.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().background(mainColor)
        ) {
            NameAndImage(
                name = name,
                balance = balance,
                image = image,
                mainColor = mainColor,
                textColor = textColor,
                secondaryColor = secondaryColor
            )
            IconButton(onClickBalance) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.eye_slash),
                    contentDescription = "eye_slash",
                    tint = textColor
                )
            }
        }
    }
}