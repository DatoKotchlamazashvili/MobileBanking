package com.example.mobilebanking.presentation.design_system.field

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun CwAmountText(
    modifier: Modifier = Modifier,
    currency: String = "USD",
    amount: String = "36.00",
    onAmountChanged: (String) -> Unit = {},
    onChangeCurrencyClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color(0xFF00BFFF),
                shape = RoundedCornerShape(16.dp)
            )
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .padding(20.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Enter Your Amount",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
                Text(
                    text = "Change Currency?",
                    color = Color(0xFFFF3B30),
                    fontSize = 14.sp,
                    modifier = Modifier.clickable { onChangeCurrencyClick() }
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = currency,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF9FB4CC)
                )
                Spacer(modifier = Modifier.width(12.dp))

                BasicTextField(
                    value = amount,
                    onValueChange = onAmountChanged,
                    textStyle = TextStyle(
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1C1C1E)
                    ),
                    modifier = Modifier
                        .defaultMinSize(minWidth = 60.dp)
                        .weight(1f)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CurrencyAmountCardPreview() {
    Surface {
        CwAmountText()
    }
}
