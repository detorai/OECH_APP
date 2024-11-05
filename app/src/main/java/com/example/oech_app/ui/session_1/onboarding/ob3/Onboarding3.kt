package com.example.oech_app.ui.session_1.onboarding.ob3

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.common.ClickableString
import com.example.oech_app.common.buttons.PrimaryButton
import com.example.oech_app.ui.theme.Primary
import com.example.oech_app.ui.theme.TextLighter
import com.example.session_1.R

@Composable
fun Onboarding3(
    onClickPrimary: () -> Unit
)
{
    Box(
        modifier = Modifier.fillMaxHeight().fillMaxWidth().background(Color.White),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier.width(346.dp).fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.startup),
                contentDescription = "Picture",
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 72.dp)
            )
            Text(
                text = "Real-time Tracking",
                color = Primary,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                lineHeight = 24.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(
                    0.dp, 0.dp, 0.dp, 10.dp
                )
            )
            Text(
                text = "Track your packages/items from the\n comfort of your home till final destination",
                color = TextLighter,
                fontWeight = FontWeight.W400,
                fontSize = 16.sp,
                lineHeight = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(
                    0.dp, 0.dp, 0.dp, 87.dp
                )
            )
            PrimaryButton(
                modifier = Modifier.padding(0.dp, 0.dp, 0.dp ,20.dp).size(342.dp ,46.dp),
                buttonText = "Sign Up",
                onClickPrimary = onClickPrimary,
                enabled = true
            )
            ClickableString(
                clickable = "Sign in",
                nonClickable = "Already have an account?",
                onClick = {}
            )
        }
    }
}