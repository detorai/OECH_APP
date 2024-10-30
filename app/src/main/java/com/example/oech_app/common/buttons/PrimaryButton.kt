package com.example.oech_app.common.buttons

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Primary

@Composable
fun PrimaryButton(
    modifier: Modifier,
    onClickPrimary: () -> Unit,
    buttonText: String
){
    Button(
        onClick = onClickPrimary,
        modifier = modifier,
        colors = ButtonColors(
            containerColor = Primary,
            contentColor = Color.White,
            disabledContentColor = Color.White,
            disabledContainerColor = Primary
        ),
        shape = RoundedCornerShape(8)

    ) {
        Text(
            text = buttonText,
            fontWeight = FontWeight.W600,
            fontSize = 14.sp,
            lineHeight = 9.38.sp,
            color = Color.White
        )
    }
}