package com.example.oech_app.ui.session_2.newpassword

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.common.buttons.PrimaryButton
import com.example.oech_app.ui.session_2.common.ScreenLabel
import com.example.oech_app.ui.session_2.common.TextFieldRow
import com.example.oech_app.ui.theme.GrayLighter
import com.example.session_1.R

@Composable
fun NewPassword(
    passwordText: String,
    repeatPasswordText: String,
    onRepeatPasswordChange: (String)-> Unit,
    onPasswordChange: (String) -> Unit,
    onClickTrailing1: () -> Unit,
    onClickTrailing2: () -> Unit,
    onLogIn: () -> Unit,
    passVisible: Boolean,
    repPassVisible: Boolean,
    allFull: Boolean
){

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
            .padding(23.dp, 155.dp, 23.dp, 0.dp)
    ) {
        ScreenLabel(
            labelText = "New Password",
            description = "Enter new password",
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 0.dp, 0.dp, 70.dp)
        )
        TextFieldRow(
            value = passwordText,
            onValueChange = onPasswordChange,
            label = "Password",
            placeholder = {
                Text(
                    "**********",
                    color = GrayLighter,
                    fontSize = 14.sp,
                    lineHeight = 16.sp
                )
            },
            visual =
            if (passVisible){
                VisualTransformation.None
            }
            else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                IconButton(
                    onClick = onClickTrailing1
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.eye_slash),
                        contentDescription = "trailing icon"
                    )
                }
            },
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(0.dp, 0.dp, 0.dp, 24.dp)
        )
        TextFieldRow(
            value = repeatPasswordText,
            onValueChange = onRepeatPasswordChange,
            label = "Confirm Password",
            placeholder = {
                Text(
                    "**********",
                    color = GrayLighter,
                    fontSize = 14.sp,
                    lineHeight = 16.sp
                )
            },
            visual =
            if (repPassVisible){
                VisualTransformation.None
            }
            else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                IconButton(
                    onClick = onClickTrailing2
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.eye_slash),
                        contentDescription = "trailing icon"
                    )
                }
            },
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(0.dp, 0.dp, 0.dp, 71.dp)
        )
        PrimaryButton(
            onClickPrimary = onLogIn,
            modifier = Modifier.fillMaxWidth(),
            buttonText = "Log In",
            enabled = allFull
        )
    }
}