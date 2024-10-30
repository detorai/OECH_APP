package com.example.oech_app.common.buttons

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Primary

@Composable
fun SecondaryButton(
    modifier: Modifier,
    onClickSecondary: () -> Unit,
    buttonText: String
){
    Button(
        onClick = onClickSecondary,
        modifier = modifier.border(
            1.dp,
            shape = RoundedCornerShape(8),
            color = Primary
        ),
        shape = RoundedCornerShape(8) ,
        colors = ButtonColors(
                containerColor = Color.White,
                contentColor = Primary,
                disabledContentColor = Primary,
                disabledContainerColor = Color.White
    )
        ) {
        Text(
            text = buttonText,
            fontWeight = FontWeight.W600,
            fontSize = 14.sp,
            lineHeight = 9.38.sp,
            color = Primary
        )
    }
}