package com.example.oech_app.ui.session_3.profile.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.TextLighter

@Composable
fun DarkModeRow(
    checked: Boolean,
    onCheckChange: (Boolean)-> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(0.dp,27.dp, 0.dp, 0.dp)
    ) {
        Text(
            "Enable dark Mode",
            color = TextLighter,
            fontSize = 16.sp,
            fontWeight = FontWeight(500),
            lineHeight = 16.sp
        )
        Switch(
            checked = checked,
            onCheckedChange = onCheckChange,
        )
    }
}