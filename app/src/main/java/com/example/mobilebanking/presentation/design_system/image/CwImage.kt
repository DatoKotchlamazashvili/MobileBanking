package com.example.mobilebanking.presentation.design_system.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CwImage(modifier: Modifier = Modifier, imageVector: ImageVector) {
    Box(
        modifier = modifier
            .size(42.dp)
            .border(0.25.dp, Color(0xFF707070), shape = CircleShape)
            .background(Color(0xFFF4F4F4), shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Image(
            imageVector = imageVector,
            contentDescription = null,
            modifier = Modifier.size(15.dp),
            alignment = Alignment.Center
        )
    }
}