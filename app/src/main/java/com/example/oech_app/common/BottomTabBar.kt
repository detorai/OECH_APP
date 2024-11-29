package com.example.oech_app.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.oech_app.ui.theme.Gray
import com.example.oech_app.ui.theme.primaryDark
import com.example.session_1.R

@Composable
fun BottomTabBar(
    textColor: Color,
    mainColor: Color
){
    var state1 by remember { mutableStateOf(false) }
    var state2 by remember { mutableStateOf(false) }
    var state3 by remember { mutableStateOf(false) }
    var state4 by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth().wrapContentHeight().background(mainColor).padding(16.dp, 10.dp)
    ){
        BottomButton(
            onClick = {state1 = !state1},
            setIcon = R.drawable.house_2,
            text = "Home",
            textColor = textColor,
            state = state1
        )
        BottomButton(
            onClick = {state2 = !state2},
            setIcon = R.drawable.wallet_3,
            text = "Wallet",
            textColor = textColor,
            state = state2
        )
        BottomButton(
            onClick = {state3 = !state3},
            setIcon = R.drawable.smart_car,
            text = "Track",
            textColor = textColor,
            state = state3
        )
        BottomButton(
            onClick = { state4 = !state4 },
            setIcon = R.drawable.profile_circle,
            text = "Profile",
            textColor = textColor,
            state = state4
        )
    }
}

@Preview
@Composable
fun PreviewBar(){
    BottomTabBar(
        mainColor = Color.White,
        textColor = Gray
    )
}