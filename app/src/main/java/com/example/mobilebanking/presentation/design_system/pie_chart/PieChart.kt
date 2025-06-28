package com.example.mobilebanking.presentation.design_system.pie_chart

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.collections.List
import kotlin.collections.forEachIndexed
import kotlin.collections.get
import kotlin.collections.map
import kotlin.collections.minus
import kotlin.sequences.minus
import kotlin.text.toFloat

data class PieData(
    val amount: Double,
    val color: Color,
)

@Composable
private fun PieChart(expenses: List<PieData>, totalExpense: Double, factor: Float = 1f) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxWidth()) {
        Canvas(modifier = Modifier.size(LocalConfiguration.current.screenWidthDp.dp / factor)) {
            val sweepAngles = expenses.map { (it.amount / totalExpense * 360).toFloat() }
            var startAngle = -90f
            val gapAngle = 12f
            expenses.forEachIndexed { index, expense ->
                drawArc(
                    color = expense.color,
                    startAngle = startAngle,
                    sweepAngle = sweepAngles[index] - gapAngle,
                    useCenter = false,
                    style = Stroke(width = 12.dp.toPx(), cap = StrokeCap.Round),
                    size = Size(size.width, size.height),
                    topLeft = Offset(0f, 0f)
                )
                startAngle += sweepAngles[index]
            }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Expense", fontSize = 18.sp)
            Text("$$totalExpense", fontSize = 12.sp)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PieChartPreview() {
    val sampleData = listOf(
        PieData(amount = 500.0, color = Color.Red),
        PieData(amount = 300.0, color = Color.Green),
        PieData(amount = 200.0, color = Color.Blue)
    )
    val totalExpense = sampleData.sumOf { it.amount }

    PieChart(expenses = sampleData, totalExpense = totalExpense)
}
