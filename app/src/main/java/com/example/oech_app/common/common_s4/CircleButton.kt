package com.example.oech_app.common.common_s4

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun CircleButton(
    onClick: ()-> Unit,
    title: String,
    @DrawableRes icon: Int,
    textColor: Color
){
    Column(
        modifier = Modifier.wrapContentHeight().wrapContentHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(
            onClick = onClick,
            modifier = Modifier.size(49.dp, 48.dp).background(color = Primary, shape = CircleShape)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(icon),
                contentDescription = "icon"
            )
        }
        Text(
            title,
            color = textColor,
            fontSize = 12.sp,
            lineHeight = 16.sp,
            fontWeight = FontWeight.W400,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Preview
@Composable
fun PrewCircle(){
    CircleButton(
        onClick = {},
        title = "Bank",
        textColor = TextLighter,
        icon = R.drawable.olymp

    )
}