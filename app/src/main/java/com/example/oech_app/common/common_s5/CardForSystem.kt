package com.example.oech_app.common.common_s5

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Primary
import com.example.oech_app.ui.theme.TextLighter
import com.example.session_1.R

@Composable
fun CardForSystem(
    @DrawableRes cardIcon: Int,
    cardLabel: String,
    cardDesc: String
){
    Column(
        modifier = Modifier.padding(20.dp)
            .background(
            shape = RoundedCornerShape(8.dp),
            color = Color(0xFFF2F2F2)
            )
            .size(159.dp)
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Icon(
            contentDescription = "",
            imageVector = ImageVector.vectorResource(cardIcon),
            modifier = Modifier.wrapContentHeight().wrapContentWidth(),
            tint = Primary
        )
        Text(
            cardLabel,
            color = Primary,
            fontSize = 16.sp,
            lineHeight = 16.sp,
            fontWeight = FontWeight.W500,
            modifier = Modifier.padding(top = 6.dp)
        )
        Text(
            cardDesc,
            fontSize = 8.sp,
            fontWeight = FontWeight.W400,
            lineHeight = 10.sp,
            color = TextLighter,
            modifier = Modifier.width(127.dp).padding(top = 6.dp)
        )
    }
}

@Preview
@Composable
fun PrevCard(){
    CardForSystem(
        cardIcon = R.drawable.call,
        cardLabel = "Customer Care",
        cardDesc = "Our customer care service line is available from 8 -9pm week days and 9 - 5 weekends - tap to call us today"
    )
}