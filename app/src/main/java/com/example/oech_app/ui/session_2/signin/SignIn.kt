package com.example.oech_app.ui.session_2.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.common.ClickableString
import com.example.oech_app.common.buttons.PrimaryButton
import com.example.oech_app.ui.session_2.common.CheckBoxRow
import com.example.oech_app.ui.session_2.common.ForgotPassClick
import com.example.oech_app.ui.session_2.common.ScreenLabel
import com.example.oech_app.ui.session_2.common.TextFieldRow
import com.example.oech_app.ui.theme.Gray
import com.example.oech_app.ui.theme.GrayLighter
import com.example.oech_app.ui.theme.Primary
import com.example.session_1.R

@Composable
fun SignIn (
    emailText: String,
    onEmailChange: (String)-> Unit,
    passwordText: String,
    onPasswordChange:(String) -> Unit,
    onClickTrailing: () -> Unit,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onForgotPass: () -> Unit,
    onLogIn: () -> Unit,
    onSignUp: () -> Unit,
    enabled: Boolean,
    passVisible: Boolean,
    field1: Boolean,
    field2: Boolean
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
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
                value = emailText,
                onValueChange = onEmailChange,
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
                label = "Email Address",
                field = field1
            )
            TextFieldRow(
                value = passwordText,
                onValueChange = onPasswordChange,
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
                label = "Password",
                field = field2
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.size(25.dp,28.dp)
                ){
                    Checkbox(
                        modifier = Modifier.size(14.dp,14.dp),
                        checked = checked,
                        onCheckedChange = onCheckedChange,
                        colors  = CheckboxDefaults.colors(
                            checkedColor = Gray,
                            checkmarkColor = Color.White,
                            uncheckedColor = Gray,
                        ),
                    )
                }
                Column {
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Text(
                            "Remember password",
                            fontWeight = FontWeight.W400,
                            fontSize = 14.sp,
                            color = Gray,
                        )
                        ForgotPassClick(onForgotPass)
                    }
                }
            }
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
                onClickPrimary = onLogIn,
                enabled = enabled
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