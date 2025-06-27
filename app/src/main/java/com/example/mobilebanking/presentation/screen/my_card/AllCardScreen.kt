package com.example.mobilebanking.presentation.screen.my_card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilebanking.presentation.design_system.button.CwButton
import com.example.mobilebanking.presentation.design_system.card.BankCard
import com.example.mobilebanking.presentation.screen.home.Card

@Composable
fun AllCardScreen(
    modifier: Modifier = Modifier,
    cards: List<Card>,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 72.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        modifier = Modifier.align(Alignment.CenterStart)
                    )
                    Text(
                        text = "My Cards",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }

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

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(vertical = 16.dp)
        ) {
            CwButton(text = "Add Card +", onClick = onClick)
        }
    }
}

@Preview
@Composable
private fun AllCardScreenPreview() {
    Surface {
        AllCardScreen(
            cards = listOf(
                Card("1234123412341234", "Davit dfotchlamazashvili", "04/2000", "334"),
                Card("1234123412341234", "Davit kotchlamazashvili", "04/2000", "334"),
                Card("1234123412341234", "Davit kotchlamazashvili", "04/2000", "334"),
                Card("1234123412341234", "Davit kotchlamazashvili", "04/2000", "334")

            )
        ) { }
    }
}