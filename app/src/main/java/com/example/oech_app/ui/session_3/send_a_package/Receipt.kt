package com.example.oech_app.ui.session_3.send_a_package

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.session_3.common.DestDetails
import com.example.oech_app.ui.session_3.common.DetRow
import com.example.oech_app.ui.session_3.common.OthDetails
import com.example.oech_app.ui.theme.Gray
import com.example.oech_app.ui.theme.Primary
import com.example.oech_app.ui.theme.TextLighter

@Composable
fun Receipt(
    addressO: String,
    phoneO: String,
    countryO: String,
    addressD1: String,
    addressD2: String,
    phoneD1: String,
    phoneD2: String,
    countryD1: String,
    countryD2: String,
    state: Boolean,
    pItems: String,
    weightP: String,
    worthP: String,
    trackNum: String,
    onEdit: ()-> Unit,
    onPayment: ()-> Unit
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(24.dp)
    ) {
        Column {
            Text(
                "Package Information",
                color = Primary,
                fontWeight = FontWeight.W500,
                fontSize = 16.sp,
                lineHeight = 16.sp,
            )
            Text(
                "Origin details",
                fontWeight = FontWeight.W400,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                color = TextLighter,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "$addressO,$countryO\n$phoneO",
                fontWeight = FontWeight.W400,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                color = Gray,
                modifier = Modifier.padding(top = 4.dp)
            )
            DestDetails(
                address = addressD1,
                address1 = addressD2,
                country = countryD1,
                country1 = countryD2,
                phone = phoneD1,
                phone1 = phoneD2,
                state = state,
                modifier = Modifier.padding(top = 8.dp)
            )
            OthDetails(
                pItems = pItems,
                weightP = weightP,
                worthP = worthP,
                trackNum = trackNum
            )
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth().height(1.dp).padding(top = 37.dp)
            )
            Text(
                "Charges",
                color = Primary,
                fontWeight = FontWeight.W500,
                fontSize = 16.sp,
                lineHeight = 16.sp,
                modifier = Modifier.padding(top = 45.dp)
            )
            DetRow(
                "Delivery Charges",
                "N2000,00"
            )
            DetRow(
                "Instat Delivery",
                "N300.00"
            )
            DetRow(
                "Tax and Service Charges",
                "N200.00"
            )
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth().height(1.dp).padding(top = 9.dp)
            )
            Row(
                modifier = Modifier.padding(top = 4.dp)
            ) {
                DetRow(
                    label = "Package Total",
                    "N2500.00"
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(top = 46.dp )
            ) {
                Button(
                    onClick = onEdit,
                    colors = ButtonColors(
                        contentColor = Primary,
                        containerColor = Color.White,
                        disabledContentColor = Primary,
                        disabledContainerColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.size(158.dp, 48.dp).border(1.dp, Primary, RoundedCornerShape(8.dp))
                ) {
                    Text(
                        "Edit Package",
                        fontWeight = FontWeight.W700,
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                    )
                }
                Button(
                    onClick = onPayment,
                    colors = ButtonColors(
                        contentColor = Color.White,
                        containerColor = Primary,
                        disabledContentColor = Color.White,
                        disabledContainerColor = Primary
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.size(158.dp, 48.dp)
                ) {
                    Text(
                        "Make Payment",
                        fontWeight = FontWeight.W700,
                        fontSize = 16.sp,
                        lineHeight = 16.sp,
                    )
                }
            }
        }
    }
}


