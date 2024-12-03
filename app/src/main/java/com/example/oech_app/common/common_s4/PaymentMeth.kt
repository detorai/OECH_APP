package com.example.oech_app.common.common_s4

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Gray
import com.example.oech_app.ui.theme.Primary

@Composable
fun PaymentMeth(
    modifier: Modifier,
    label: String,
    desc: String,
    textColor: Color,
    secondaryColor: Color,
    makeChoose: () -> Unit,
    choose: Boolean
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .fillMaxWidth()
            .height(84.dp)
            .background(secondaryColor)
            .shadow(1.dp)
    ) {
        Column {
            RadioButton(
                selected = choose,
                onClick = makeChoose,
                colors = RadioButtonColors(
                    selectedColor = Primary,
                    unselectedColor = Primary,
                    disabledSelectedColor = Color.White,
                    disabledUnselectedColor = Color.White
                )
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .wrapContentWidth()
                .fillMaxHeight()
        ) {
            Text(
                label,
                fontWeight = FontWeight.W400,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                color = textColor
            )
            Text(
                desc,
                fontWeight = FontWeight.W400,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                color = Gray
            )
        }
    }
}
