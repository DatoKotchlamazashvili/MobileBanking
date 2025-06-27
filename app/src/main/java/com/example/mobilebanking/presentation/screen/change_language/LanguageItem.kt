package com.example.mobilebanking.presentation.screen.change_language

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.CheckCircleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LanguageItem(
    modifier: Modifier = Modifier,
    imageRes: ImageVector,
    name: String,
    isSelected: Boolean = false,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp), // fixed height for alignment consistency
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Flag Icon
        Icon(
            imageVector = imageRes,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )

        // Language Name
        Text(
            text = name,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        )

        // Checkmark Icon (only if selected)
        if (isSelected) {
            Icon(
                imageVector = Icons.Default.CheckCircleOutline,
                contentDescription = null,
                tint = Color(0xFF4CAF50), // optional: green check
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Preview
@Composable
private fun LanguageItemPreview() {
    Surface {
        LanguageItem(
            imageRes = Icons.Default.AccountBox,
            name = "england",
            isSelected = true
        )
    }
}