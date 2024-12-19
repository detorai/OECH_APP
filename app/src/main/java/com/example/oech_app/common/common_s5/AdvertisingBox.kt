package com.example.oech_app.common.common_s5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.oech_app.ui.theme.Secondary

@Composable
fun AdvertisingBox(
    modifier: Modifier,
    content: String
){
    Box(
        modifier = modifier
            .height(64.dp)
            .width(166.dp)
            .background(
                shape = RoundedCornerShape(8.dp),
                color = Secondary
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            content,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun PrevBox(){
    AdvertisingBox(
        modifier = Modifier,
        content = "1"
    )
}
