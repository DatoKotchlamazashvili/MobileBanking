package com.example.mobilebanking.presentation.design_system.card

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Whatsapp
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
import com.example.mobilebanking.presentation.design_system.image.CwImage
import com.example.mobilebanking.ui.theme.Blue100
import com.example.mobilebanking.ui.theme.MobileBankingTheme
import kotlin.math.absoluteValue


@Composable
fun TransactionCard(
    modifier: Modifier = Modifier,
    company: String,
    category: String,
    amount: Double,
    imageVector: ImageVector,
) {

    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {

        CwImage(imageVector = imageVector)

        Column(
            modifier = Modifier
                .padding(start = 17.dp)
                .weight(1f),
        ) {
            Text(fontWeight = FontWeight.Bold, text = company, fontSize = 16.sp)


            Text(text = category, fontSize = 12.sp)

        }

        Text(
            text = if (amount < 0) "- $ ${amount.absoluteValue}" else "$$amount",
            color = if (amount < 0) Color.Black else Blue100

        )
    }
}


@Preview
@Composable
private fun TransactionCardPreview() {
    MobileBankingTheme {
        Surface {
            TransactionCard(
                modifier = Modifier.fillMaxWidth(),
                company = "Apple",
                category = "Entertaiment",
                amount = 172.123,
                imageVector = Icons.Default.Whatsapp
            )
        }
    }
}