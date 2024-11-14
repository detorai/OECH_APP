package com.example.oech_app.ui.session_3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.session_1.R

@Composable
fun BottomTab(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(16.dp, 10.dp)
    ){
        BottomTabButton(
            onClick = {},
            setIcon = R.drawable.house_2,
            text = "Home"
        )
        BottomTabButton(
            onClick = {},
            setIcon = R.drawable.wallet_3,
            text = "Wallet"
        )
        BottomTabButton(
            onClick = {},
            setIcon = R.drawable.smart_car,
            text = "Track"
        )
        BottomTabButton(
            onClick = {},
            setIcon = R.drawable.profile_circle,
            text = "Profile"
        )
    }
}