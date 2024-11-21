package com.example.oech_app.ui.session_3.profile.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.session_1.R

@Composable
fun ProfileContent(
    @DrawableRes image: Int,
    balance: String,
    name: String,
    checked: Boolean,
    onCheckChange: (Boolean) -> Unit,
    mainColor: Color,
    secondaryColor: Color,
    textColor: Color,
    onClickBalance: ()-> Unit,
    onBankClick: ()-> Unit
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
        DarkModeRow(
            checked = checked,
            onCheckChange = onCheckChange,
            mainColor = mainColor,
            secondaryColor = secondaryColor,
            textColor = textColor
        )
        ProfileButton(
            icon = R.drawable.profile_circle,
            label = "Edit Profile",
            description = "Name, phone no, address, email ...",
            modifier = Modifier.padding(0.dp, 19.dp, 0.dp, 0.dp),
            mainColor = mainColor,
            secondaryColor = secondaryColor,
            textColor = textColor
        )
        ProfileButton(
            icon = R.drawable.group,
            label = "Statements & Reports",
            description = "Download transaction details, orders, deliveries",
            modifier = Modifier.padding(0.dp, 12.dp, 0.dp, 0.dp),
            mainColor = mainColor,
            secondaryColor = secondaryColor,
            textColor = textColor
        )
        ProfileButton(
            icon = R.drawable.notification,
            label = "Notification Settings",
            description = "mute, unmute, set location & tracking setting",
            modifier = Modifier.padding(0.dp, 12.dp, 0.dp, 0.dp),
            mainColor = mainColor,
            secondaryColor = secondaryColor,
            textColor = textColor
        )
        ProfileButton(
            icon = R.drawable.wallet_3,
            label = "Card & Bank account settings",
            description = "change cards, delete card details",
            modifier = Modifier.padding(0.dp, 12.dp, 0.dp, 0.dp).clickable { onBankClick() },
            mainColor = mainColor,
            secondaryColor = secondaryColor,
            textColor = textColor
        )
        ProfileButton(
            icon = R.drawable.carbon_two_person_lift,
            label = "Referrals",
            description = "check no of friends and earn",
            modifier = Modifier.padding(0.dp, 12.dp, 0.dp, 0.dp),
            mainColor = mainColor,
            secondaryColor = secondaryColor,
            textColor = textColor
        )
        ProfileButton(
            icon = R.drawable.map,
            label = "About Us",
            description = "know more about us, terms and conditions",
            modifier = Modifier.padding(0.dp, 12.dp, 0.dp, 0.dp),
            mainColor = mainColor,
            secondaryColor = secondaryColor,
            textColor = textColor
        )
        LogOutButton(
            modifier = Modifier.padding(0.dp, 12.dp, 0.dp, 0.dp),
            mainColor = mainColor,
            secondaryColor = secondaryColor,
            textColor = textColor
        )
    }
}