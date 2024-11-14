package com.example.oech_app.ui.session_3

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Gray
import com.example.session_1.R

@Composable
fun BottomTabButton(
    @DrawableRes setIcon: Int,
    text: String,
    onClick: () -> Unit
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxHeight().wrapContentWidth().clickable {
            onClick()
        }
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(setIcon),
            contentDescription = "Icon",
        )
        Text(
            text,
            fontWeight = FontWeight.W400,
            fontSize = 12.sp,
            lineHeight = 14.sp,
            color = Gray
        )
    }
}