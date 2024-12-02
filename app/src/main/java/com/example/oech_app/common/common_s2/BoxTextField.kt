package com.example.oech_app.common.common_s2

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.oech_app.ui.theme.Gray
import com.example.oech_app.ui.theme.Primary

@Composable
fun BoxTextField(
    inputText: String,
    onValueChange: (String) -> Unit,
    onNextFocus: () -> Unit,
    modifier: Modifier,
    focusRequester: FocusRequester,
    field1: Boolean
){
    var borderColor by remember { mutableStateOf(Gray) }

    BasicTextField(
        value = inputText,
        onValueChange = { it ->
            if (it.length <= 1 && (it.all { it.isDigit() } || it.isEmpty())) {
                onValueChange(it)
                borderColor = if (it.isEmpty()) {
                    Gray
                } else if (it.all { char -> char.isDigit() }) {
                    Primary
                }
                else {
                    Color.Red
                }
            }
            if (it.length == 1) {
                onNextFocus()
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        decorationBox = {
            Box(
                modifier = modifier
                    .size(32.dp, 32.dp)
                    .border(
                        1.dp,
                        if (!field1){
                        borderColor
                        }
                        else {
                            Color.Red
                        }
                    )
                    .focusable(),
                contentAlignment = Alignment.Center
            ) {
                Text(inputText, modifier.align(Alignment.Center))
            }
        }
    )
}


@SuppressLint("AutoboxingStateCreation")
@Composable
fun FullBoxTextField(
    numFields: Int = 6,
    modifier: Modifier,
    codeText: List<String>,
    onValueChange: (Int, String) -> Unit,
    field1: Boolean
) {
    val focusRequesters = List(numFields) { FocusRequester() }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 0 until numFields) {
            BoxTextField(
                inputText = codeText[i],
                onValueChange = { newValue -> onValueChange(i, newValue) },
                onNextFocus = {
                    if (i < numFields - 1){
                        focusRequesters[i + 1].requestFocus()
                    }
                },
                modifier = Modifier.focusRequester(focusRequesters[i]),
                focusRequester = focusRequesters[i],
                field1 = field1
            )
        }
    }
}