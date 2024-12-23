package com.example.oech_app.ui.session_3.add_payment_method

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.oech_app.common.AppTopBar
import com.example.oech_app.common.common_s4.PaymentMeth

@Composable
fun AddPaymentMethod(
    onClickBack: () -> Unit,
    secondaryColor: Color,
    mainColor: Color,
    textColor: Color,
    choose: Int,
    makeChoose1: ()-> Unit,
    othChoose: Int,
    makeChoose2: ()-> Unit,
    onDelete1: ()-> Unit,
    onDelete2: () -> Unit,
    state1 : Boolean,
    state2: Boolean,
    makeChooseCard1: ()-> Unit,
    makeChooseCard2: () -> Unit
){
    Scaffold(
        topBar = {
            AppTopBar(
                label = "Add Payment method",
                onClickBack = onClickBack,
                secondaryColor = secondaryColor
            )
        },

    ) { innerPadding ->

        Box(
            modifier = Modifier.fillMaxWidth().fillMaxHeight().background(mainColor).padding(innerPadding),
            contentAlignment = Alignment.TopCenter
        ){
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 67.dp, start = 25.dp, end = 25.dp )
            ) {
                PaymentMeth(
                    choose = choose == 1,
                    desc = "complete the payment using your e wallet",
                    label = "Pay with wallet",
                    makeChoose = makeChoose1,
                    secondaryColor = secondaryColor,
                    textColor = textColor,
                    modifier = Modifier,
                    height = 84,
                    othChoose = othChoose == 1,
                    onDelete1 = onDelete1,
                    state1 = state1,
                    makeChooseCard1 = makeChooseCard1,
                    onDelete2 = onDelete2,
                    state2 = state2,
                    makeChooseCard2 = makeChooseCard2
                )
                PaymentMeth(
                    choose = choose == 2,
                    desc = "complete the payment using your debit card",
                    label = "Credit / debit card",
                    makeChoose = makeChoose2,
                    secondaryColor = secondaryColor,
                    textColor = textColor,
                    modifier = Modifier.padding(top = 12.dp),
                    height = if (choose == 1){
                        84
                    } else {
                        233
                    },
                    othChoose = othChoose == 2,
                    onDelete1 = onDelete1,
                    state1 = state1,
                    makeChooseCard1 = makeChooseCard1,
                    onDelete2 = onDelete2,
                    state2 = state2,
                    makeChooseCard2 = makeChooseCard2
                )
            }
        }
    }
}
