package com.example.oech_app.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.session_1.R

@Composable
fun BottomTabBar(
    textColor: Color,
    mainColor: Color,
    onHome: ()-> Unit,
    onWallet: ()-> Unit,
    onTrack: ()-> Unit,
    onProfile: ()-> Unit,
    selectedTabIndex: Int
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth().wrapContentHeight().shadow(4.dp).background(mainColor).padding(start = 16.dp, bottom = 10.dp, end = 16.dp)
    ){
        BottomButton(
            onClick = {
                onHome()
                      },
            setIcon = R.drawable.house_2,
            pickIcon = R.drawable.house_2click,
            text = "Home",
            textColor = textColor,
            state = selectedTabIndex == 1
        )
        BottomButton(
            onClick = {
                onWallet()
                      },
            setIcon = R.drawable.wallet_3,
            pickIcon = R.drawable.wallet_3click,
            text = "Wallet",
            textColor = textColor,
            state = selectedTabIndex == 2
        )
        BottomButton(
            onClick = {
                onTrack()
                      },
            setIcon = R.drawable.smart_car,
            pickIcon = R.drawable.selected_car,
            text = "Track",
            textColor = textColor,
            state = selectedTabIndex == 3
        )
        BottomButton(
            onClick = {
                onProfile()
                      },
            setIcon = R.drawable.profile_circle,
            pickIcon = R.drawable.profile_circleclick,
            text = "Profile",
            textColor = textColor,
            state = selectedTabIndex == 4
        )
    }
}
