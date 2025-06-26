package com.example.mobilebanking

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AppBlocking
import androidx.compose.material.icons.filled.SportsTennis
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.mobilebanking.presentation.screen.home.Card
import com.example.mobilebanking.presentation.screen.home.HomeScreenContent
import com.example.mobilebanking.presentation.screen.home.Transaction
import com.example.mobilebanking.ui.theme.MobileBankingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobileBankingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreenContent(
                        modifier = Modifier.fillMaxSize().padding(innerPadding),
                        fullName = "DAvit kotchlamazashvili",
                        cards = listOf(
                            Card("1234123412341234", "Davit dfotchlamazashvili", "04/2000", "334"),
                            Card("1234123412341234", "Davit kotchlamazashvili", "04/2000", "334")

                        ),
                        transactions =listOf(
                            Transaction(
                                "apple", "entertaiment", 235.23, Icons.Default.AppBlocking
                            ),
                            Transaction(
                                "spotify", "music", -12.23, Icons.Default.SportsTennis
                            ), Transaction(
                                "apple", "entertaiment", 22.0, Icons.Default.Whatsapp
                            ),
                            Transaction(
                                "apple", "entertaiment", 235.23, Icons.Default.AppBlocking
                            )

                        )
                    )
                }
            }
        }
    }
}
