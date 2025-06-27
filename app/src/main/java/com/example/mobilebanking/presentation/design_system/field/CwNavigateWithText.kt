package com.example.mobilebanking.presentation.design_system.field

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowRightAlt
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobilebanking.ui.theme.lightGray100


@Composable
fun CwNavigateWithText(
    modifier: Modifier = Modifier,
    mainText: String,
    subText: String? = null,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = mainText, color = Color.Black, fontWeight = FontWeight.Medium)

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            subText?.let {
                Text(text = it, color = lightGray100, modifier = Modifier.padding(end = 16.dp))
            }

            Image(imageVector = Icons.AutoMirrored.Filled.ArrowRightAlt, contentDescription = null)
        }
    }
}


@Preview
@Composable
private fun CwNavigateWithTextPreview() {
    Surface {
        CwNavigateWithText(
            modifier = Modifier.fillMaxWidth(),
            mainText = "Change language",
            subText = "English",
        )
    }
}