package com.example.mobilebanking.presentation.screen.my_card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.PersonPin
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
import com.example.mobilebanking.presentation.design_system.card.BankCard
import com.example.mobilebanking.presentation.design_system.field.CwInputEditField

@Composable
fun AddCardScreen(
    modifier: Modifier = Modifier,
    cardNumber: String,
    expiryDate: String,
    ccv: String,
    cardHolder: String,
    onCardNumberChanged: (String) -> Unit,
    onExpiryChanged: (String) -> Unit,
    onCcvChanged: (String) -> Unit,
    onCardHolderChanged: (String) -> Unit,

    ) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterStart)
            )

            Text(
                text = "Add Card",
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(31.dp))

        BankCard(
            cardNumber = cardNumber.chunked(4),
            fullName = cardHolder,
            expiryDate = expiryDate,
            ccv = ccv,
        )
        Spacer(modifier = Modifier.height(29.dp))

        CwInputEditField(
            value = cardHolder,
            onValueChange = onCardHolderChanged,
            leadingIconRes = Icons.Default.PersonPin,
            hint = "john Doe",
            title = "CardHolder Name"
        )

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            CwInputEditField(
                value = expiryDate,
                modifier = Modifier.weight(1f),
                onValueChange = onExpiryChanged,
                hint = "01/01/2000",
                title = "Expiry Date"
            )
            CwInputEditField(
                value = ccv,
                modifier = Modifier.weight(1f),
                onValueChange = onCcvChanged,
                hint = "john Doe",
                title = "4-digit CCV"
            )
        }
        CwInputEditField(
            value = cardNumber,
            onValueChange = onCardNumberChanged,
            leadingIconRes = Icons.Default.CreditCard,
            hint = "5555 5555 5555 5555",
            title = "Card Number"
        )
    }
}


@Preview
@Composable
private fun AddCardScreenPreview() {
    Surface {
        AddCardScreen(
            cardNumber = "32423467587",
            expiryDate = "03/12/2005",
            ccv = "4446",
            cardHolder = "",
            onCardNumberChanged = { },
            onExpiryChanged = { },
            onCcvChanged = {},
            onCardHolderChanged = { }
        )
    }
}