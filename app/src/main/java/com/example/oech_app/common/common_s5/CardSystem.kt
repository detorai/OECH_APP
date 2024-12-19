package com.example.oech_app.common.common_s5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Primary

@Composable
fun CardSystem(
    modifier: Modifier
){
    Column(
        modifier = modifier.fillMaxWidth().background(Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                "What would you like to do",
                fontWeight = FontWeight.W500,
                fontSize = 14.sp,
                lineHeight = 16.sp,
                color = Primary
            )
        }

    }
}