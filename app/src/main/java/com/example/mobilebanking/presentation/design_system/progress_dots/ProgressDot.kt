package com.example.mobilebanking.presentation.design_system.progress_dots

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobilebanking.ui.theme.Blue100
import com.example.mobilebanking.ui.theme.Blue20
import com.example.mobilebanking.ui.theme.MobileBankingTheme




@Composable
fun ProgressDot(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
) {
    if (isSelected) {
        Box(
            modifier = modifier
                .width(19.dp)
                .height(6.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(Blue100)
        )
    } else {
        Box(
            modifier = modifier
                .size(6.dp)
                .clip(CircleShape)
                .background(Blue20)
        )
    }
}

@Composable
fun ProgressDotRow(modifier: Modifier = Modifier,count:Int,isSelected:(Int)-> Boolean) {
    Row(modifier = modifier.heightIn(max = 6.dp)) {
        (0..<count).map {
            ProgressDot(modifier = Modifier.padding(end = 7.dp),isSelected = isSelected(it))
        }
    }
}


@Preview
@Composable
fun ProgressDotPreview() {
    MobileBankingTheme {
        ProgressDot(isSelected = true)
    }
}

@Preview
@Composable
private fun ProgressDotRowPreview() {
    val index = 0
    MobileBankingTheme {
        ProgressDotRow(count = 2, isSelected = {index == it})
    }
}