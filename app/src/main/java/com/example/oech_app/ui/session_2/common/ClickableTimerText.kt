package com.example.oech_app.ui.session_2.common

import android.annotation.SuppressLint
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Gray
import com.example.oech_app.ui.theme.Primary
import kotlinx.coroutines.delay

@SuppressLint("DefaultLocale")
@Composable
fun ClickableTimerText(
    onClick: () -> Unit,
    timerSeconds: Int = 5
){
    var isClickable by remember { mutableStateOf(false) }
    var countdown by remember { mutableIntStateOf(timerSeconds) }
    var timerVisible by remember { mutableStateOf(true) }

    LaunchedEffect(timerVisible) {
        if (timerVisible) {
            countdown = timerSeconds
            isClickable = false
            while (countdown > 0) {
                delay(1000L)
                countdown--
            }
            isClickable = true
            timerVisible = false
        }
    }


    val minutes = countdown / 60
    val seconds = countdown % 60
    val timeDisplay = String.format("%02d:%02d", minutes, seconds)


    val annotatedText = buildAnnotatedString {
        withStyle(
            SpanStyle(
            fontWeight = FontWeight.W400,
            fontSize = 14.sp,
            color = Gray
        )
        ) {
            append("If you didn’t receive code, ")
        }
        pushStringAnnotation("click", "clickable")
        withStyle(
            SpanStyle(
            color =
                if (timerVisible){
                    Gray
                } else {
                    Primary
                },
            fontWeight = FontWeight.W400,
            fontSize = 14.sp
        )
        ) {
            append("resend")
        }
        if (timerVisible) {
            withStyle(SpanStyle(
                color = Gray,
                fontWeight = FontWeight.W400,
                fontSize = 14.sp
            )) {
                append(" after $timeDisplay")
            }
        }
        pop()
    }
    ClickableText(
        text = annotatedText,
        onClick = { offset ->
            if (isClickable){
            annotatedText.getStringAnnotations(offset, offset)
                .firstOrNull()
                ?.let { annotation ->
                    if (annotation.item == "clickable" && isClickable) {
                        onClick()
                        isClickable = false
                        timerVisible = true
                    }
                }
            }
        }
    )
}