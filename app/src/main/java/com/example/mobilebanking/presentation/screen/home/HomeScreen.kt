package com.example.mobilebanking.presentation.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AppBlocking
import androidx.compose.material.icons.filled.ArrowCircleUp
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Person2
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SportsTennis
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.mobilebanking.presentation.design_system.card.BankCard
import com.example.mobilebanking.presentation.design_system.card.TransactionCard
import com.example.mobilebanking.presentation.design_system.image.CwImage
import com.example.mobilebanking.ui.theme.Blue100
import com.example.mobilebanking.ui.theme.MobileBankingTheme
import com.example.mobilebanking.ui.theme.lightGray100


data class ActionTypes(val imageVector: ImageVector, val text: String)

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    fullName: String,
    cards: List<Card>,
    transactions: List<Transaction>,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    imageVector = Icons.Default.Person2,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .weight(1f)
                ) {
                    Text("Welcome Back,", color = lightGray100)
                    Text(fullName, fontWeight = FontWeight.SemiBold)
                }
                CwImage(imageVector = Icons.Default.Search)
            }
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
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                val icons = listOf(
                    ActionTypes(Icons.Default.ArrowUpward, "Sent"),
                    ActionTypes(Icons.Default.ArrowDownward, "Receive"),
                    ActionTypes(Icons.Default.MonetizationOn, "Loan"),
                    ActionTypes(Icons.Default.ArrowCircleUp, "Topup")
                )
                icons.forEach {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CwImage(imageVector = it.imageVector)
                        Text(text = it.text)
                    }
                }
            }
        }

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Transaction", fontWeight = FontWeight.Bold)
                Text("See All", color = Blue100)
            }
        }

        items(transactions) { transaction ->
            TransactionCard(
                company = transaction.company,
                category = transaction.category,
                amount = transaction.amount,
                imageVector = transaction.imageVector
            )
        }
    }
}


@Preview
@PreviewScreenSizes
@Composable
private fun HomeScreenContentPreview() {
    MobileBankingTheme {
        Surface {
            HomeScreenContent(
                modifier = Modifier.fillMaxSize(),
                fullName = "DAvit kotchlamazashvili", cards = listOf(
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