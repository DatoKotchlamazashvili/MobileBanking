package com.example.mobilebanking.presentation.screen.home

import androidx.compose.ui.graphics.vector.ImageVector

data class Transaction(
    val company: String,
    val category: String,
    val amount: Double,
    val imageVector: ImageVector,
)
