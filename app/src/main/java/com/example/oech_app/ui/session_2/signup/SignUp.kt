package com.example.oech_app.ui.session_2.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.oech_app.ui.session_2.common.ScreenLabel
import com.example.oech_app.ui.session_2.common.TextFieldRow

@Composable
fun SignUp(
    fnValue: String,
    fnOnChange: (String) -> Unit,

){
    Box(
        modifier = Modifier.fillMaxHeight().fillMaxWidth().background(Color.White),
        contentAlignment = Alignment.Center
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            ScreenLabel(
                labelText = "Create an account",
                description = "Complete the sign up process to get started",
                modifier = Modifier.fillMaxWidth()
            )
            TextFieldRow(
                value = fnValue,
                onValueChange = fnOnChange,
                label = {
                    Text(
                    "Full name",
                        )
                        },
                placeholder = {
                    Text(
                        "Ivanov Ivan"
                    )
                },
                trailingIcon = {},
                modifier = Modifier.size(342.dp, 44.dp)
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}