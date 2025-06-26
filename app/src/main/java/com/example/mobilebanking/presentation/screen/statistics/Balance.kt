package com.example.mobilebanking.presentation.screen.statistics

data class Balance(
    val balance: Double,
    val months: List<String>,
    val value: List<Double>,
)