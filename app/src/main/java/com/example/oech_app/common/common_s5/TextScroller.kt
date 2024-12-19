package com.example.oech_app.common.common_s5

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oech_app.ui.theme.Primary
import com.example.oech_app.ui.theme.Secondary
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TextScroller(
    modifier: Modifier
) {
    val textBlocks = listOf(
        "1",
        "2",
        "3",
        "4"
    )
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()

            ) {
            Text(
                "Special for you",
                fontWeight = FontWeight.W500,
                fontSize = 14.sp,
                lineHeight = 16.sp,
                color = Secondary
            )
            IconButton(
                onClick = {
                    val nextPage = if (pagerState.currentPage < (textBlocks.size + 1) / 2 - 1) {
                        pagerState.currentPage + 1
                    } else {
                        0
                    }
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(nextPage)
                    }
                },
                modifier = Modifier
                    .size(14.dp)

            ) {
                Icon(
                    Icons.Default.KeyboardArrowRight,
                    contentDescription = "icon",
                    tint = Secondary,
                    modifier = Modifier
                        .size(12.dp)
                        .border(
                            1.dp,
                            shape = RoundedCornerShape(4.dp),
                            color = Secondary
                        )
                )
            }
        }

        Spacer(modifier = Modifier.height(7.dp))

        HorizontalPager(
            count = (textBlocks.size + 1) / 2,
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                val firstIndex = page * 2
                val secondIndex = firstIndex + 1
                if (firstIndex < textBlocks.size) {
                    AdvertisingBox(
                        content = textBlocks[firstIndex],
                        modifier = Modifier
                )
            }
                if (secondIndex < textBlocks.size) {
                    AdvertisingBox(
                        content = textBlocks[secondIndex],
                        modifier = Modifier
                    )
                }
            }
        }
    }
}