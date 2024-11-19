package com.example.oech_app.ui.session_3.profile.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    onCheckChange: (Boolean) -> Unit
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(25.dp, 25.dp, 25.dp, 0.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            NameAndImage(
                name = name,
                balance = balance,
                image = image
            )
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.eye_slash),
                contentDescription = "eye_slash"
            )
        }
        DarkModeRow(
            checked = checked,
            onCheckChange = onCheckChange
        )
        ProfileButton(
            icon = R.drawable.profile_circle,
            label = "Edit Profile",
            description = "Name, phone no, address, email ...",
            modifier = Modifier.padding(0.dp, 19.dp, 0.dp, 0.dp)
        )
        ProfileButton(
            icon = R.drawable.group,
            label = "Statements & Reports",
            description = "Download transaction details, orders, deliveries",
            modifier = Modifier.padding(0.dp, 12.dp, 0.dp, 0.dp)
        )
        ProfileButton(
            icon = R.drawable.notification,
            label = "Notification Settings",
            description = "mute, unmute, set location & tracking setting",
            modifier = Modifier.padding(0.dp, 12.dp, 0.dp, 0.dp)
        )
        ProfileButton(
            icon = R.drawable.wallet_3,
            label = "Card & Bank account settings",
            description = "change cards, delete card details",
            modifier = Modifier.padding(0.dp, 12.dp, 0.dp, 0.dp)
        )
        ProfileButton(
            icon = R.drawable.carbon_two_person_lift,
            label = "Referrals",
            description = "check no of friends and earn",
            modifier = Modifier.padding(0.dp, 12.dp, 0.dp, 0.dp)
        )
        ProfileButton(
            icon = R.drawable.map,
            label = "About Us",
            description = "know more about us, terms and conditions",
            modifier = Modifier.padding(0.dp, 12.dp, 0.dp, 0.dp)
        )
        LogOutButton(
            modifier = Modifier.padding(0.dp, 12.dp, 0.dp, 0.dp)
        )
    }
}