package com.example.oech_app.ui.session_3.add_payment_method

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.oech_app.common.AppTopBar

@Composable
fun AddPaymentMethod(
    onClickBack: () -> Unit,
    secondaryColor: Color,
){
    Scaffold(
        topBar = {
            AppTopBar(
                label = "Add Payment method",
                onClickBack = onClickBack,
                secondaryColor = secondaryColor
            )
        }
    ) { innerPadding ->

        Box(
            modifier = Modifier.padding(innerPadding)
        )
    }
}
