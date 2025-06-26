package com.example.mobilebanking.presentation.screen.my_card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AppBlocking
import androidx.compose.material.icons.filled.SportsTennis
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilebanking.presentation.design_system.card.BankCard
import com.example.mobilebanking.presentation.design_system.card.TransactionCard
import com.example.mobilebanking.presentation.design_system.image.CwImage
import com.example.mobilebanking.presentation.design_system.slider.CwSlider
import com.example.mobilebanking.presentation.screen.home.Card
import com.example.mobilebanking.presentation.screen.home.Transaction

@Composable
fun MyCardScreen(
    modifier: Modifier = Modifier,
    cards: List<Card>,
    transactions: List<Transaction>,

    ) {
    var currentBalance by remember {
        mutableDoubleStateOf(450.0)
    }
    var currentMaxLimit by remember {
        mutableFloatStateOf(2680f)
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CwImage(imageVector = Icons.AutoMirrored.Filled.ArrowBack)

                Text("My Card", fontWeight = FontWeight.Bold, color = Color.Black)

                CwImage(imageVector = Icons.Default.Add)

            }
            Spacer(modifier = Modifier.height(32.dp))
        }

        item {
            LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                items(cards) { card ->
                    BankCard(
                        modifier = Modifier.width(320.dp),
                        cardNumber = card.cardNumber.chunked(4),
                        fullName = card.fullName,
                        expiryDate = card.expiryDate,
                        ccv = card.ccv
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))

        }
        items(transactions) { transaction ->
            TransactionCard(
                company = transaction.company,
                category = transaction.category,
                amount = transaction.amount,
                imageVector = transaction.imageVector
            )
        }

        item {
            Text(text = "Monthly Spending Limit", fontWeight = FontWeight.Medium, fontSize = 18.sp)

            CwSlider(
                currentBalance = currentBalance,
                currentMaxLimit = currentMaxLimit,
                onValueChange = {
                    currentMaxLimit = it
                },
            )
        }
    }
}

@Preview
@Composable
private fun MyCardScreenPreview() {
    MaterialTheme {
        Surface {
            MyCardScreen(
                cards = listOf(
                    Card("1234123412341234", "Davit dfotchlamazashvili", "04/2000", "334"),
                    Card("1234123412341234", "Davit kotchlamazashvili", "04/2000", "334")

                ), transactions = listOf(
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