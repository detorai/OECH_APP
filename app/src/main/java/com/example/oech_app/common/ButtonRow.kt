package com.example.oech_app.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.oech_app.common.buttons.PrimaryButton
import com.example.oech_app.common.buttons.SecondaryButton


@Composable
fun ButtonRow(
    onClickPrimary: () -> Unit,
    onClickSecondary: () -> Unit,
){
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        SecondaryButton(
            modifier = Modifier.size(100.dp, 50.dp),
            buttonText = "Skip",
            onClickSecondary = onClickSecondary
        )
        PrimaryButton(
            modifier = Modifier.size(100.dp, 50.dp),
            buttonText = "Next",
            onClickPrimary = onClickPrimary,
            enabled = true
        )
    }
}