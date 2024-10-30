package com.example.oech_app.ui.session_1.onboarding.ob2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.common.ButtonRow
import com.example.oech_app.ui.theme.Primary
import com.example.oech_app.ui.theme.TextLighter
import com.example.session_1.R

@Composable
fun OnBoarding2 (
    onClickPrimary: () -> Unit,
    onClickSecondly: () -> Unit
){
        Box(
            modifier = Modifier.fillMaxHeight().fillMaxWidth().background(Color.White),
            contentAlignment = Alignment.Center
        ){
            Column(
                modifier = Modifier.width(346.dp).fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.rafiki),
                    contentDescription = "Picture",
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 72.dp)
                )
                Text(
                    text = "Flexible Payment",
                    color = Primary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    lineHeight = 24.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(
                        0.dp, 0.dp, 0.dp, 10.dp
                    )
                )
                Text(
                    text = "Different modes of payment either\n before and after delivery without\n stress",
                    color = TextLighter,
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(
                        0.dp, 0.dp, 0.dp, 87.dp
                    )
                )
                ButtonRow(
                    onClickPrimary = onClickPrimary,
                    onClickSecondary = onClickSecondly
                )
            }
        }
}