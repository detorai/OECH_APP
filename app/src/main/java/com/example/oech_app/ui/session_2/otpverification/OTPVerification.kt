package com.example.oech_app.ui.session_2.otpverification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.oech_app.common.buttons.PrimaryButton
import com.example.oech_app.ui.session_2.common.ClickableTimerText
import com.example.oech_app.ui.session_2.common.FullBoxTextField
import com.example.oech_app.ui.session_2.common.ScreenLabel

@Composable
fun OTPVerification(
    codeText: List<String>,
    onValueChange: (Int, String) -> Unit,
    onClick: ()-> Unit,
    onSetPass: () -> Unit
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth().fillMaxHeight().background(Color.White).padding(23.dp, 155.dp, 23.dp, 0.dp)
    ) {
        Column {
            ScreenLabel(
                labelText = "OTP Verification",
                description = "Enter the 6 digit numbers sent to your email",
                modifier = Modifier.fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 70.dp)
            )
            FullBoxTextField(
                codeText = codeText,
                modifier = Modifier.fillMaxWidth().padding(0.dp, 0.dp, 0.dp, 12.dp),
                onValueChange = onValueChange
            )
        }
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            ClickableTimerText(
                onClick = onClick
            )
            PrimaryButton(
                modifier = Modifier.fillMaxWidth().padding(0.dp, 84.dp, 0.dp, 0.dp),
                buttonText = "Set New Password",
                onClickPrimary = onSetPass,
                enabled = true
            )
        }
    }
}