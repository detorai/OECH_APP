package com.example.oech_app.ui.session_2.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.oech_app.common.ClickableString
import com.example.oech_app.ui.theme.Primary

@Composable
fun CheckBoxRow(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClick: () -> Unit
){
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth()
    ){
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Checkbox(
                checked = checked,
                onCheckedChange = onCheckedChange,
                colors  = CheckboxDefaults.colors(
                    checkedColor = Primary,
                    checkmarkColor = Color.White,
                    uncheckedColor = Color.White,
                ),
            )
        }
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(25.dp, 0.dp, 0.dp, 0.dp),
        ) {
            ClickableString(
                nonClickable = "By ticking this box, you agree to our ",
                clickable = "Terms and\n                conditions and private policy",
                onClick = onClick
            )
        }
    }
}