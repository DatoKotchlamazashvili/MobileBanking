package com.example.mobilebanking.presentation.design_system.date

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilebanking.ui.theme.Gray100
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

enum class MonthText {
    Text, Number
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CwDatePicker(
    modifier: Modifier = Modifier,
    date: Long,
    title: String,
    onDateSelected: (Long?) -> Unit,
    monthFormat: MonthText = MonthText.Number,
) {
    val datePickerState = rememberDatePickerState()
    var isShown by remember { mutableStateOf(false) }
    val dateParts = remember(date, monthFormat) {
        parseDateParts(date, monthFormat)
    }

    Column(modifier = modifier) {
        Text(title, color = Gray100)

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val items = if (dateParts.isEmpty()) listOf("DD", "MM", "YYYY") else dateParts
            val textColor = if (dateParts.isEmpty()) Color.Gray else Color.Black

            items.forEach { value ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .border(
                            width = 1.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .background(Color.White, RoundedCornerShape(8.dp))
                        .clickable { isShown = true },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = value,
                        color = textColor,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }

        if (isShown) {
            DatePickerDialog(
                onDismissRequest = { isShown = false },
                confirmButton = {
                    TextButton(onClick = {
                        datePickerState.selectedDateMillis?.let {
                            onDateSelected(it)
                        }
                        isShown = false
                    }) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { isShown = false }) {
                        Text("Cancel")
                    }
                }
            ) {
                DatePicker(state = datePickerState)
            }
        }
    }
}


@Preview
@Composable
private fun CwDatePickerPreview() {
    Surface {
        CwDatePicker(
            onDateSelected = { }, monthFormat = MonthText.Text,
            title = "Months bue by",
            date = 5L,
        )
    }
}

private fun parseDateParts(selectedDateMillis: Long, format: MonthText): List<String> {
    if (selectedDateMillis <= 0L) return emptyList()

    val calendar = Calendar.getInstance().apply {
        timeInMillis = selectedDateMillis
    }

    val day = calendar.get(Calendar.DAY_OF_MONTH).toString()
    val year = calendar.get(Calendar.YEAR).toString()

    val month = when (format) {
        MonthText.Number -> (calendar.get(Calendar.MONTH) + 1).toString()
        MonthText.Text -> SimpleDateFormat("MMMM", Locale.getDefault()).format(calendar.time)
    }

    return listOf(day, month, year)
}