package com.example.oech_app.common.common_s4

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.session_1.R

@Composable
fun TopUp(
    textColor: Color,
    secondaryColor: Color,
    onBank: ()-> Unit,
    onTransfer: ()-> Unit,
    onCard: ()-> Unit,
    modifier: Modifier
){
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth().height(116.dp).background(secondaryColor, shape = RoundedCornerShape(8.dp))
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth().wrapContentHeight()
        ) {
            Text(
                "Top Up",
                color = textColor,
                fontWeight = FontWeight.W700,
                fontSize = 16.sp,
                lineHeight = 16.sp,
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth().wrapContentHeight()
        ) {
            CircleButton(
                title = "Bank",
                onClick = onBank,
                icon = R.drawable.olymp,
                textColor = textColor
            )
            CircleButton(
                title = "Transfer",
                onClick = onTransfer,
                icon = R.drawable.transfer,
                textColor = textColor
            )
            CircleButton(
                title = "Card",
                onClick = onCard,
                icon = R.drawable.card,
                textColor = textColor
            )
        }
    }
}

