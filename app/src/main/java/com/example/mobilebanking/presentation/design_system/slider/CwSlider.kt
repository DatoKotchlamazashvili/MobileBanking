package com.example.mobilebanking.presentation.design_system.slider

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CwSlider(
    modifier: Modifier = Modifier,
    currentBalance: Double,
    currentMaxLimit: Float,
    onValueChange: (Float) -> Unit,
    valueRange: ClosedFloatingPointRange<Float> = 0f..10_000f,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            ,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Amount: $${"%,.2f".format(currentBalance)}",
                fontSize = 14.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Slider(
                value = currentMaxLimit,
                onValueChange = onValueChange,
                valueRange = valueRange,
                steps = 0,
                modifier = Modifier.fillMaxWidth(),
                colors = SliderDefaults.colors(
                    thumbColor = Color(0xFF006FFF),
                    activeTrackColor = Color(0xFF006FFF),
                    inactiveTrackColor = Color(0xFFDDDDDD)
                )
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "$${valueRange.start.toInt()}", fontSize = 12.sp, color = Color.Gray)
                Text(
                    text = "$${"%,.0f".format(currentMaxLimit)}",
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$${valueRange.endInclusive.toInt()}",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CwSliderPreview() {
    var sliderPos by remember { mutableStateOf(4600f) }
    CwSlider(
        currentBalance = 8_545.00,
        currentMaxLimit = sliderPos,
        onValueChange = { sliderPos = it }
    )
}
