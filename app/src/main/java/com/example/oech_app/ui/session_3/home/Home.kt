package com.example.oech_app.ui.session_3.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.oech_app.ui.session_3.BottomTab

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Home(){
        Scaffold(
            bottomBar = { BottomTab() },
            modifier = Modifier.fillMaxWidth().fillMaxWidth()
        )
        {
            Row {
                Text(
                    "Home"
                )
            }
        }
}