package com.example.oech_app.ui.session_2.forgotpassword

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.common.ClickableString
import com.example.oech_app.common.buttons.PrimaryButton
import com.example.oech_app.ui.session_2.common.ScreenLabel
import com.example.oech_app.ui.session_2.common.TextFieldRow
import com.example.oech_app.ui.theme.GrayLighter

@Composable
fun ForgotPassword (
    fnValue: String,
    fnOnChange: (String)-> Unit,
    onSignIn: () -> Unit,
    onSendOTP: () -> Unit
) {
    val allFull = fnValue.isNotBlank()

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth().fillMaxHeight().background(Color.White)
            .padding(23.dp, 155.dp, 23.dp, 0.dp),
    ) {
        Column {
            ScreenLabel(
                labelText = "Forgot Password",
                description = "Enter your email address",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 56.dp)
            )
            TextFieldRow(
                value = fnValue,
                onValueChange = fnOnChange,
                placeholder = {
                    Text(
                        "***********@mail.com",
                        color = GrayLighter,
                        fontSize = 14.sp,
                        lineHeight = 16.sp
                    )
                },
                trailingIcon = {},
                modifier = Modifier
                    .wrapContentHeight(),
                label = "Email Address"
            )
        }
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 56.dp, 0.dp, 0.dp)
        ) {
            PrimaryButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(0.dp, 0.dp, 0.dp, 20.dp),
                buttonText = "Send OTP",
                onClickPrimary = onSendOTP,
                enabled = allFull
            )
            ClickableString(
                clickable = "Sign In",
                nonClickable = "Remember password? Back to ",
                onClick = onSignIn
            )
        }
    }
}