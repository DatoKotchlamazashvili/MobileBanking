package com.example.mobilebanking.presentation.screen.statistics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AppBlocking
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.SportsTennis
import androidx.compose.material.icons.filled.Whatsapp
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mobilebanking.presentation.design_system.card.TransactionCard
import com.example.mobilebanking.presentation.design_system.image.CwImage
import com.example.mobilebanking.presentation.design_system.stock.CwStock
import com.example.mobilebanking.presentation.screen.home.Transaction
import com.example.mobilebanking.ui.theme.Blue100
import com.example.mobilebanking.ui.theme.MobileBankingTheme


@Composable
fun StatisticsScreen(
    modifier: Modifier = Modifier, balance: Balance, transactions: List<Transaction>,
) {

    var selectedIndex: Int by remember {
        mutableIntStateOf(
            0
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CwImage(imageVector = Icons.AutoMirrored.Filled.ArrowBack)

            Text("Statistics", fontWeight = FontWeight.Bold, color = Color.Black)

            CwImage(imageVector = Icons.Default.Notifications)

        }

        Spacer(modifier = Modifier.height(32.dp))

        CwStock(
            balance = balance.balance,
            xAxis = balance.months,
            yAxis = balance.value.map { it.toFloat() },
            selected = selectedIndex,
            onSelectedChanged = { selectedIndex = it }
        )
        Spacer(modifier = Modifier.height(30.dp))

        LazyColumn {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("Transaction", fontWeight = FontWeight.Bold)
                    Text("See All", color = Blue100)
                }
                Spacer(modifier = Modifier.height(21.dp))

            }

            items(transactions) { transaction ->
                TransactionCard(
                    modifier = Modifier.padding(top = 8.dp),
                    company = transaction.company,
                    category = transaction.category,
                    amount = transaction.amount,
                    imageVector = transaction.imageVector
                )
            }
        }
    }

}

@Preview
@Composable
private fun StatisticsScreenPreview() {
    MobileBankingTheme {
        Surface {
            StatisticsScreen(
                balance = Balance(
                    balance = 123.45,
                    months = listOf("Oct", "Nov", "Dec", "Jan", "Feb", "Mar"),
                    value = listOf(213.0, 634.0, 452.0, 1023.0, 834.0, 124.0)
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