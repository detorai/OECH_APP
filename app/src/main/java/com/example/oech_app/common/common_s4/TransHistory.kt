package com.example.oech_app.common.common_s4

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TransHistory(
    textColor: Color,
    modifier: Modifier,
    secondaryColor: Color
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = modifier.wrapContentHeight().fillMaxWidth()
    ) {
        Text(
            "Transfers History",
            color = textColor,
            fontWeight = FontWeight.W500,
            fontSize = 20.sp,
            lineHeight = 20.sp
        )
        Column(
            modifier = Modifier.verticalScroll(ScrollState(0))
        ) {
            Transfer(
                cost = "N1412,512:00",
                dest = "AppMarket",
                date = "July 21, 2024",
                modifier = Modifier.padding(top = 24.dp).background(secondaryColor)
            )
        }
    }
}