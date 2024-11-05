package com.example.oech_app.ui.session_2.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.common.ClickableString
import com.example.oech_app.common.buttons.PrimaryButton
import com.example.oech_app.ui.session_2.common.CheckBoxRow
import com.example.oech_app.ui.session_2.common.ScreenLabel
import com.example.oech_app.ui.session_2.common.TextFieldRow
import com.example.oech_app.ui.theme.Gray
import com.example.oech_app.ui.theme.GrayLighter
import com.example.session_1.R

@Composable
fun SignIn (
    fnValue: String,
    fnOnChange: (String)-> Unit,
    onClickTrailing: () -> Unit,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onForPass: () -> Unit,
    onLogIn: () -> Unit,
    onSignUp: () -> Unit
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
            .padding(23.dp, 155.dp, 23.dp, 0.dp),
    ){
        Column {
            ScreenLabel(
                labelText = "Welcome Back",
                description = "Fill in your email and password to continue",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 0.dp, 0.dp, 28.dp)
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
                    .wrapContentHeight()
                    .padding(0.dp, 0.dp, 0.dp, 18.dp),
                label = "Email Address"
            )
            TextFieldRow(
                value = fnValue,
                onValueChange = fnOnChange,
                placeholder = {
                    Text(
                        "**********",
                        color = GrayLighter,
                        fontSize = 14.sp,
                        lineHeight = 16.sp
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = onClickTrailing
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.eye_slash),
                            contentDescription = "trailing icon"
                        )
                    }
                },
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(0.dp, 0.dp, 0.dp, 18.dp),
                label = "Password"
            )
            CheckBoxRow(
                checked = checked,
                onCheckedChange = onCheckedChange,
                onClick = onForPass,
                clickable = "                           Forgot Password?",
                nonClickable = "Remember password",
                modifier = Modifier,
                colorPrime = Gray
            )
        }
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 100.dp, 0.dp, 0.dp)
        ) {
            PrimaryButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(0.dp, 0.dp, 0.dp, 20.dp),
                buttonText = "Log In",
                onClickPrimary = onLogIn
            )
            ClickableString(
                clickable = "Sign Up",
                nonClickable = "Don't have an account?",
                onClick = onSignUp
            )
            Text(
                "or log in using",
                fontWeight = FontWeight.W400,
                fontSize = 14.sp,
                color = Gray,
                modifier = Modifier.padding(0.dp, 18.dp, 0.dp, 0.dp)
            )
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.gmail),
                    contentDescription = "gmail",
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 28.dp)
                )
            }
        }
    }
}