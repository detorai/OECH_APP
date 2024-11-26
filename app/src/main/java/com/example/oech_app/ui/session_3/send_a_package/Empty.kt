package com.example.oech_app.ui.session_3.send_a_package

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.session_3.common.AddDestination
import com.example.oech_app.ui.session_3.common.DetailsRow
import com.example.oech_app.ui.session_3.common.SelectDeliveryType
import com.example.oech_app.ui.session_3.common.TextRow
import com.example.oech_app.ui.theme.TextLighter
import com.example.session_1.R


@Composable
fun Empty(
    state: Boolean,
    onClickPrimary: ()-> Unit,
    onClickSecondly: () ->  Unit,
    onClickAdd:() -> Unit,

    modifier: Modifier,

    addressO: String,
    onAddressO: (String) -> Unit,

    countryO: String,
    onCountryO: (String) -> Unit,

    phoneO: String,
    onPhoneO: (String) -> Unit,

    othersO: String,
    onOthersO: (String) -> Unit,

    addressD1: String,
    onAddressD1: (String) -> Unit,

    countryD1: String,
    onCountryD1: (String) -> Unit,

    phoneD1: String,
    onPhoneD1: (String) -> Unit,

    othersD1: String,
    onOthersD1: (String) -> Unit,

    addressD2: String,
    onAddressD2: (String) -> Unit,

    countryD2: String,
    onCountryD2: (String) -> Unit,

    phoneD2: String,
    onPhoneD2: (String) -> Unit,

    othersD2: String,
    onOthersD2: (String) -> Unit,

    items: String,
    onItems: (String) -> Unit,

    weight: String,
    onWeight: (String) -> Unit,

    worth: String,
    onWorth: (String) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 43.dp)
        ) {
            DetailsRow(
                icon = R.drawable.sun,
                labelName = "Origin Details",
                address = addressO,
                country = countryO,
                phone = phoneO,
                others = othersO,
                onOthers = onOthersO,
                onAddress = onAddressO,
                onPhone = onPhoneO,
                onCountry = onCountryO
            )
        }
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 39.dp)
        ) {
            DetailsRow(
                icon = R.drawable.mark,
                labelName = "Destination Details",
                address = addressD1,
                country = countryD1,
                phone = phoneD1,
                others = othersD1,
                onOthers = onOthersD1,
                onAddress = onAddressD1,
                onPhone = onPhoneD1,
                onCountry = onCountryD1
            )
        }
        AddDestination(
            state = state,
            addressD = addressD2,
            countryD = countryD2,
            phoneD = phoneD2,
            othersD = othersD2,
            onOthersD = onOthersD2,
            onAddressD = onAddressD2,
            onPhoneD = onPhoneD2,
            onCountryD = onCountryD2,
            onClickAdd = onClickAdd
        )
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth().wrapContentHeight()
                .padding(start = 24.dp, end = 24.dp, top = 24.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.padding(bottom = 5.dp).fillMaxWidth().wrapContentHeight()
            ) {
                Column {
                    Text(
                        "Package Details",
                        fontWeight = FontWeight.W500,
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                        color = TextLighter
                    )
                }
            }
            TextRow(
                inputText = items,
                onValue = onItems,
                modifier = Modifier,
                placeholder = "package items"
            )
            TextRow(
                inputText = weight,
                onValue = onWeight,
                modifier = Modifier.padding(top = 5.dp),
                placeholder = "Weight of item(kg)"
            )
            TextRow(
                inputText = worth,
                onValue = onWorth,
                modifier = Modifier.padding(top = 5.dp),
                placeholder = "Worth of Items"
            )
        }
        SelectDeliveryType(
            onClickPrimary = onClickPrimary,
            onClickSecondly = onClickSecondly,
            modifier = Modifier.padding(top = 39.dp, bottom = 15.dp)
        )
    }
}