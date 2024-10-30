package com.example.oech_app.ui.session_2.common

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.oech_app.ui.theme.Gray

@Composable
fun TextFieldRow(
    value: String,
    onValueChange: (String) -> Unit,
    label:@Composable () -> Unit,
    placeholder:@Composable () -> Unit,
    trailingIcon:@Composable () -> Unit,
    modifier: Modifier
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = label,
        trailingIcon = trailingIcon,
        placeholder = placeholder,
        shape = RoundedCornerShape(4),
        modifier = modifier.border(
            width = 1.dp,
            shape = RoundedCornerShape(4),
            color = Gray
        )
    )
}