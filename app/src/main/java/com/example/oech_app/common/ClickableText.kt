package com.example.oech_app.common

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Gray
import com.example.oech_app.ui.theme.Primary
import com.example.oech_app.ui.theme.Secondary

@Composable
fun ClickableString(
    nonClickable: String,
    clickable: String,
    onClick: () -> Unit
){
    val annotatedText = buildAnnotatedString {
        withStyle(SpanStyle(
            fontWeight = FontWeight.W400,
            fontSize = 14.sp,
            color = Gray
        )) {
            append(nonClickable)
        }
        pushStringAnnotation("click", "clickable")
        withStyle(SpanStyle(
            color = Primary,
            fontWeight = FontWeight.W400,
            fontSize = 14.sp
        )) {
            append(clickable)
        }
        pop()
    }
    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            annotatedText.getStringAnnotations(offset, offset).firstOrNull()?.let {
                annotation ->
                when (annotation.item) {
                    "clickable" -> onClick()
                }
            }
        }
    )
}