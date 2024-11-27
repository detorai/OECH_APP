package com.example.oech_app.ui.session_3.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.oech_app.ui.theme.Secondary
import com.example.oech_app.ui.theme.Success
import com.example.session_1.R


@Composable
fun CircularProgressBar(loading: Boolean){
    Row {
        when (loading) {
            true ->
                Column(
                    modifier = Modifier.size(119.dp).background(Success, shape = CircleShape),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {  Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.succ),
                    contentDescription = "",
                    tint = Color.White

                    )
                }


            false -> CircularProgressIndicator(
                modifier = Modifier.size(119.dp),
                strokeWidth = 10.dp,
                color = Secondary,
                trackColor = Color.White
            )
        }
    }
}