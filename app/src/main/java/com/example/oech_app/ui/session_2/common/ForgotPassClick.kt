package com.example.oech_app.ui.session_2.common

import androidx.compose.foundation.background
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Primary

@Composable
fun ForgotPassClick(onForgotPass: ()-> Unit){
    val annotatedText = buildAnnotatedString {
        pushStringAnnotation("click", "clickable")
        withStyle(
            SpanStyle(
                color = Primary,
                fontWeight = FontWeight.W400,
                fontSize = 14.sp
            )
        ) {
            append("Forgot Password?")
        }
    }

    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            annotatedText.getStringAnnotations(offset, offset).firstOrNull()?.let {
                    annotation ->
                when (annotation.item) {
                    "clickable" -> onForgotPass()
                }
            }
        }
    )
}