package com.example.oech_app.common.common_s4

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.session_1.R

@Composable
fun StarRatingBar(
    modifier: Modifier = Modifier,
    rating: Int,
    onRatingChanged: (Int) -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        for (i in 1..5) {
            Star(
                isFilled = i <= rating,
                onClick = { onRatingChanged(i) }
            )
        }
    }
}

@Composable
fun Star(
    isFilled: Boolean,
    onClick: () -> Unit
) {
    val starIcon: ImageVector = if (isFilled) {
        ImageVector.vectorResource(id = R.drawable.full_star) // Замените этот ресурс на вашу иконку звезды
    } else {
        ImageVector.vectorResource(id = R.drawable.outline_star) // Замените этот ресурс на вашу иконку незаполненной звезды
    }

    Icon(
        imageVector = starIcon,
        contentDescription = if (isFilled) "Filled Star" else "Empty Star",
        modifier = Modifier
            .padding(8.dp)
            .size(17.dp)
            .clickable(onClick = onClick),
        tint = Color.Unspecified
    )
}

@Preview
@Composable
fun PrevStar(){
    var rating by remember { mutableIntStateOf(0) }
    StarRatingBar(
        rating = rating,
        onRatingChanged = {newRating ->
            rating = newRating
        }
    )
}