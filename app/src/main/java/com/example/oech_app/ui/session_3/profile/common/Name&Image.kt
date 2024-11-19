package com.example.oech_app.ui.session_3.profile.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NameAndImage(
    @DrawableRes image: Int,
    name: String,
    balance: String
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.wrapContentWidth().wrapContentHeight()
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = "Profile Photo",
            modifier = Modifier.size(60.dp).background(shape = RoundedCornerShape(60.dp), color = Color.White)
        )
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.wrapContentHeight().padding(5.dp, 0.dp, 0.dp, 0.dp)
        ) {
            Text(
                "Hello $name",
                fontSize = 16.sp,
                fontWeight = FontWeight(500),
                lineHeight = 30.sp
                )
            Text(
                "Current balance: $balance"
            )
        }
    }
}