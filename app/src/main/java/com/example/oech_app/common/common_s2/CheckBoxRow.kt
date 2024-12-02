package com.example.oech_app.common.common_s2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.oech_app.common.ClickableString


@Composable
fun CheckBoxRow(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClick: () -> Unit,
    clickable: String,
    nonClickable: String,
    modifier: Modifier,
    colorPrime: Color
){
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
                    checkedColor = colorPrime,
                    checkmarkColor = Color.White,
                    uncheckedColor = colorPrime,
                ),
            )
        }
        Column(
            modifier = modifier,
        ) {
            ClickableString(
                nonClickable = nonClickable,
                clickable = clickable,
                onClick = onClick
            )
        }
    }
}

