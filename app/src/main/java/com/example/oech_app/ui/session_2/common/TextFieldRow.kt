package com.example.oech_app.ui.session_2.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Gray

@Composable
fun TextFieldRow(
    value: String,
    onValueChange: (String) -> Unit,
    label:String,
    placeholder:@Composable () -> Unit,
    trailingIcon:@Composable () -> Unit,
    modifier: Modifier,
    visual: VisualTransformation = VisualTransformation.None,
    field: Boolean
){
    Text(
        label,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        textAlign = TextAlign.Center,
        color = Gray,
        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
    )
    OutlinedTextField(
        visualTransformation = visual,
        value = value,
        onValueChange = onValueChange,
        trailingIcon = trailingIcon,
        placeholder = placeholder,
        shape = RoundedCornerShape(4.dp),
        modifier = modifier.border(
            width = 1.dp,
            shape = RoundedCornerShape(4.dp),
            color = when (field) {
                true -> Color.Red
                false -> Color.Gray
            }
        ).fillMaxWidth(),
    )
}