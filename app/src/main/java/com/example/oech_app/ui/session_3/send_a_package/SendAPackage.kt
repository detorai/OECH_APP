package com.example.oech_app.ui.session_3.send_a_package




//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.oech_app.common.AppTopBar

@Composable
fun SendAPackage(
    onClickBack: ()-> Unit,
    onClickPrimary: ()-> Unit,
    onClickSecondly: () ->  Unit,
    secondaryColor: Color,

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

    screenState: Boolean,
    trackNum: String,
    state: Boolean,
    onClickAdd: ()-> Unit,
    onEdit: ()-> Unit,
    onPayment: ()-> Unit
){


    Scaffold(
        topBar = { AppTopBar(
            label = "Send a package",
            onClickBack = onClickBack,
            secondaryColor = secondaryColor
            )
        },
    ) {innerPadding ->
            Empty(
                modifier = Modifier.padding(innerPadding).verticalScroll(ScrollState(0)),
                addressO = addressO,
                addressD1 = addressD1,
                addressD2 = addressD2,
                countryO = countryO,
                countryD1 = countryD1,
                countryD2 = countryD2,
                phoneD1 = phoneD1,
                phoneO = phoneO,
                phoneD2 = phoneD2,
                othersO = othersO,
                othersD1 = othersD1,
                othersD2 = othersD2,
                onClickPrimary = onClickPrimary,
                onClickSecondly = onClickSecondly,
                onClickAdd = onClickAdd,
                onWeight = onWeight,
                onItems = onItems,
                onWorth = onWorth,
                onPhoneO = onPhoneO,
                onOthersO = onOthersO,
                onAddressO = onAddressO,
                onCountryO = onCountryO,
                onPhoneD1 = onPhoneD1,
                onPhoneD2 = onPhoneD2,
                onOthersD1 = onOthersD1,
                onOthersD2 = onOthersD2,
                onAddressD1 = onAddressD1,
                onAddressD2 = onAddressD2,
                onCountryD1 = onCountryD1,
                onCountryD2 = onCountryD2,
                worth = worth,
                weight = weight,
                items = items,
                state = state
            )
            Receipt(
                addressO = addressO,
                addressD1 = addressD1,
                addressD2 = addressD2,
                countryO = countryO,
                countryD1 = countryD1,
                countryD2 = countryD2,
                phoneD1 = phoneD1,
                phoneO = phoneO,
                phoneD2 = phoneD2,
                worthP = worth,
                weightP = weight,
                pItems = items,
                state = state,
                trackNum = trackNum,
                onEdit = onEdit,
                onPayment = onPayment
            )

    }
}


























/*Column (
        modifier = Modifier.padding(innerPadding).verticalScroll(ScrollState(0)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ){
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
            onClickAdd = {
                state = true
            },
        )
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(start = 24.dp, end = 24.dp, top = 24.dp)
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
    }*/