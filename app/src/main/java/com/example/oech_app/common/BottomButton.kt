package com.example.oech_app.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Primary

@Composable
fun BottomButton(
    @DrawableRes setIcon: Int,
    @DrawableRes pickIcon: Int,
    text: String,
    onClick: () -> Unit,
    textColor: Color,
    state: Boolean
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.width(35.dp).height(45.dp).clickable {
            onClick()
        }
    ) {
        if (state) {
            HorizontalDivider(
                modifier = Modifier.width(34.dp).height(5.dp).padding(bottom = 8.dp),
                color = Primary
            )
        }
        Icon(
            imageVector = ImageVector.vectorResource(
                if (state) {
                    pickIcon
                } else {
                    setIcon
                }
            ),
            contentDescription = "Icon",
            tint = Color.Unspecified
        )
        Text(
            text,
            fontWeight = FontWeight.W400,
            fontSize = 12.sp,
            lineHeight = 14.sp,
            color = if (state){
                Primary
            } else {
                textColor
            }
        )
    }
}