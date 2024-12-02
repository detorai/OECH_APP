package com.example.oech_app.common.common_s3

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.GrayLighter
import com.example.oech_app.ui.theme.TextLighter

@Composable
fun TextRow(
    placeholder: String,
    inputText: String,
    onValue: (String)-> Unit,
    modifier: Modifier
) {
    BasicTextField(
        value = inputText,
        modifier = modifier,
        onValueChange = onValue,
        decorationBox = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp)
                    .shadow(1.dp),
                contentAlignment = Alignment.Center
            ) {
                if (inputText.isEmpty()) {
                    Text(
                        placeholder,
                        modifier = Modifier.align(Alignment.CenterStart).padding(start = 8.dp),
                        fontWeight = FontWeight.W400,
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        color = GrayLighter
                        )
                } else  {
                    Text(
                        inputText,
                        modifier = Modifier.align(Alignment.CenterStart).padding(start = 8.dp),
                        fontWeight = FontWeight.W400,
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        color = TextLighter
                        )
                }
            }
        }
    )
}


