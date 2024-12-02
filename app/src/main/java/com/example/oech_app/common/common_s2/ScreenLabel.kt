package com.example.oech_app.common.common_s2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight.Companion.W500
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Gray
import com.example.oech_app.ui.theme.TextLighter

@Composable
fun ScreenLabel(
    labelText: String,
    description: String,
    modifier: Modifier
){
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start,
        modifier = modifier
    ) {
        Text(
            text = labelText,
            fontSize = 24.sp,
            fontWeight = W500,
            lineHeight = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp),
            color = TextLighter
        )
        Text(
            text = description,
            fontSize = 14.sp,
            fontWeight = W500,
            lineHeight = 16.sp,
            textAlign = TextAlign.Center,
            color = Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen(){
    ScreenLabel(labelText = "Create an account",
        description = "Complete the sign up process to get started",
        modifier = Modifier)
}