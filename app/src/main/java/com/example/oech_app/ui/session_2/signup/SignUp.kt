package com.example.oech_app.ui.session_2.signup

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
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
import com.example.oech_app.ui.theme.TextLighter
import com.example.session_1.R

@Composable
fun SignUp(
    fnValue: String,
    fnOnChange: (String) -> Unit,
    onClickTrailing1: () -> Unit,
    onClickTrailing2: () -> Unit,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
){
    Box(
        modifier = Modifier.fillMaxHeight().fillMaxWidth().background(Color.White),
        contentAlignment = Alignment.TopCenter
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(23.dp, 75.dp, 23.dp, 0.dp)
        ) {
            ScreenLabel(
                labelText = "Create an account",
                description = "Complete the sign up process to get started",
                modifier = Modifier.fillMaxWidth().padding(0.dp, 0.dp, 0.dp, 28.dp)
            )
            TextFieldRow(
                value = fnValue,
                onValueChange = fnOnChange,
                placeholder = {
                    Text(
                        "Ivanov Ivan",
                        color = GrayLighter,
                        fontSize = 14.sp,
                        lineHeight = 16.sp
                    )
                },
                trailingIcon = {},
                modifier = Modifier.wrapContentHeight().padding(0.dp, 0.dp, 0.dp, 18.dp),
                label = "Full name"
            )
            TextFieldRow(
                value = fnValue,
                onValueChange = fnOnChange,
                placeholder = {
                    Text(
                        "+7(999)999-99-99",
                        color = GrayLighter,
                        fontSize = 14.sp,
                        lineHeight = 16.sp
                    )
                },
                trailingIcon = {},
                modifier = Modifier.wrapContentHeight().padding(0.dp, 0.dp, 0.dp, 18.dp),
                label = "Phone Number"
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
                modifier = Modifier.wrapContentHeight().padding(0.dp, 0.dp, 0.dp, 18.dp),
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
                        onClick = onClickTrailing1
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.eye_slash),
                            contentDescription = "trailing icon"
                        )
                    }
                },
                modifier = Modifier.wrapContentHeight().padding(0.dp, 0.dp, 0.dp, 18.dp),
                label = "Password"
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
                        onClick = onClickTrailing2
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.eye_slash),
                            contentDescription = "trailing icon"
                        )
                    }
                },
                modifier = Modifier.wrapContentHeight().padding(0.dp, 0.dp, 0.dp, 37.dp),
                label = "Confirm Password"
            )
            CheckBoxRow(
                checked = checked,
                onCheckedChange = onCheckedChange,
                onClick = {}
            )
        }
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth().padding(23.dp, 0.dp, 23.dp, 0.dp)
        ) {
            PrimaryButton(
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 20.dp).fillMaxWidth().wrapContentHeight(),
                buttonText = "Sign Up",
                onClickPrimary = {}
            )
            ClickableString(
                clickable = "Sign In",
                nonClickable = "Already have an account?",
                onClick = {}
            )
            Text(
                "or sign in using",
                fontWeight = FontWeight.W400,
                fontSize = 14.sp,
                color = Gray,
                modifier = Modifier.padding(0.dp, 18.dp, 0.dp , 0.dp)
            )
            IconButton(
                onClick = {}
            ) {
                Icon (
                    imageVector = ImageVector.vectorResource(R.drawable.gmail),
                    contentDescription = "gmail",
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 28.dp)
                )
            }
        }
    }
}