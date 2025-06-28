package com.example.mobilebanking.presentation.screen.money_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
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
import com.example.mobilebanking.presentation.design_system.button.CwButton
import com.example.mobilebanking.presentation.design_system.date.CwDatePicker
import com.example.mobilebanking.presentation.design_system.date.MonthText
import com.example.mobilebanking.presentation.design_system.field.CwAmountText
import com.example.mobilebanking.presentation.design_system.field.CwInputEditField

@Composable
fun CwRequestMoneyScreen(
    modifier: Modifier = Modifier,
    payerName: String,
    onPayerNameChanged: (String) -> Unit,
    email: String,
    onEmailChanged: (String) -> Unit,
    description: String,
    onDescriptionChanged: (String) -> Unit,
    date: Long,
    onDateChanged: (Long?) -> Unit,
    amount: Double,
    onAmountChange: (String) -> Unit,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Column {
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
                    text = "Receive Money",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            CwInputEditField(
                value = payerName,
                onValueChange = onPayerNameChanged,
                leadingIconRes = Icons.Default.PersonPin,
                hint = "John Doe",
                title = "Payer Name",
            )
            Spacer(modifier = Modifier.height(21.dp))

            CwInputEditField(
                value = email,
                onValueChange = onEmailChanged,
                leadingIconRes = Icons.Default.Email,
                hint = "JohnDoe@gmail.com",
                title = "Email",
            )
            Spacer(modifier = Modifier.height(21.dp))

            CwInputEditField(
                value = description,
                onValueChange = onDescriptionChanged,
                leadingIconRes = Icons.Default.PersonPin,
                hint = "John Doe",
                title = "Payer Name",
            )
            Spacer(modifier = Modifier.height(21.dp))

            CwDatePicker(
                date = date,
                title = "Months Due By",
                onDateSelected = onDateChanged,
                monthFormat = MonthText.Number
            )
            Spacer(modifier = Modifier.height(32.dp))
            CwAmountText(
                modifier = Modifier.fillMaxWidth(),
                amount = amount.toString(),
                onAmountChanged = onAmountChange,
                onChangeCurrencyClick = { }
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(vertical = 16.dp)
        ) {
            CwButton(text = "Request Money", onClick = onClick)
        }
    }

}

@Preview
@Composable
private fun CwRequestMoneyScreenPreview() {
    Surface {
        CwRequestMoneyScreen(
            payerName = "",
            onPayerNameChanged = { },
            email = "",
            onEmailChanged = { },
            description = "",
            onDescriptionChanged = { },
            date = 12323L,
            onDateChanged = { },
            amount = 2334.0,
            onAmountChange = { },
            onClick = { }
        )
    }
}