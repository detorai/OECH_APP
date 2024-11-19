package com.example.oech_app.ui.session_3.profile

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.session_3.profile.common.ProfileContent
import com.example.oech_app.ui.theme.Gray


@Composable
fun Profile(
    @DrawableRes image: Int,
    balance: String,
    name: String,
    checked: Boolean,
    onCheckChange: (Boolean) -> Unit
) {
    Scaffold(
        topBar = {
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth().height(108.dp).shadow(1.dp)
            ) {
                Text(
                    "Profile",
                    color = Gray,
                    fontWeight = FontWeight.W500,
                    fontSize = 16.sp,
                    lineHeight = 16.sp,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 19.dp)
                )
            }
        }
    ) {innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        )
        ProfileContent(
            name = name,
            balance = balance,
            image = image,
            checked = checked,
            onCheckChange = onCheckChange
        )
    }
}