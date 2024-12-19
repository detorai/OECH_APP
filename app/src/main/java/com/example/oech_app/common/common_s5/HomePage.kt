package com.example.oech_app.common.common_s5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.oech_app.ui.theme.Primary
import com.example.session_1.R

@Composable
fun HomePage(
    inputText: String,
    onValue: (String) -> Unit
){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(25.dp)
    ) {
        TargetSearchBar(
            inputText = inputText,
            onValue = onValue,
            modifier = Modifier.fillMaxWidth(),
            placeholder = "Search services"
        )
        NameAndImageRow(
            image = R.drawable.profile_image,
            trailingIcon = R.drawable.notification,
            backgroundColor = Primary,
            modifier = Modifier.padding(top = 24.dp),
            welcomeText = "Hello Ken!",
            description = "We trust you are having a great time",
            textColor = Color.White,
            textSizeDesc = 12,
            textSizeWelc = 24,
            boxHeight = 91
        )
        TextScroller(
            modifier = Modifier.padding(top = 39.dp)
        )
    }
}