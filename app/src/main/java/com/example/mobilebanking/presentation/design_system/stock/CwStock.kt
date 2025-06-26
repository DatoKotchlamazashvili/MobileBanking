package com.example.mobilebanking.presentation.design_system.stock

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilebanking.ui.theme.MobileBankingTheme

@Composable
fun CwStock(
    modifier: Modifier = Modifier,
    balance: Double,
    xAxis: List<String>,
    yAxis: List<Float>,
    selected: Int,
    onSelectedChanged: (Int) -> Unit,
) {

    Column(
        modifier = modifier.padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Current Balance", fontSize = 16.sp, color = Color.Gray)

        Spacer(Modifier.height(4.dp))

        Text("$ $balance", fontSize = 32.sp, fontWeight = FontWeight.Bold)

        Spacer(Modifier.height(24.dp))

        Box(
            Modifier
                .height(200.dp)
                .fillMaxWidth()
        ) {
            StockChart(
                modifier = Modifier.fillMaxSize(),
                values = yAxis,
                selectedIndex = selected
            )
        }

        Spacer(Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            xAxis.forEachIndexed { idx, label ->
                val isSelected = idx == selected
                Text(
                    text = label.toString(),
                    fontSize = 14.sp,
                    color = if (isSelected) Color.White else Color.Gray,
                    modifier = Modifier
                        .weight(1f)
                        .padding(vertical = 6.dp)
                        .background(
                            color = if (isSelected) Color(0xFF006FFF) else Color.Transparent,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .clickable { onSelectedChanged(idx) }
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Composable
fun StockChart(
    modifier: Modifier = Modifier,
    values: List<Float>,
    selectedIndex: Int,
    lineColor: Color = Color(0xFF006FFF),
    gradientBottomColor: Color = Color(0xFF006FFF).copy(alpha = 0.1f),
    strokeWidth: Dp = 3.dp,
) {
    val maxValue = values.maxOrNull() ?: 1f
    val minValue = values.minOrNull() ?: 0f
    val range = (maxValue - minValue).takeIf { it > 0 } ?: 1f

    Canvas(modifier = modifier) {
        val w = size.width
        val h = size.height
        val count = values.size
        val spacing = w / (count - 1)

        val pts = values.mapIndexed { i, v ->
            Offset(x = i * spacing, y = h - ((v - minValue) / range) * h)
        }


        val smoothPath = Path().apply {
            if (pts.size > 1) {
                moveTo(pts[0].x, pts[0].y)
                for (i in 0 until pts.lastIndex) {
                    val p0 = pts.getOrElse(i - 1) { pts[i] }
                    val p1 = pts[i]
                    val p2 = pts[i + 1]
                    val p3 = pts.getOrElse(i + 2) { p2 }

                    val tension = 0.2f
                    val cp1 = p1 + (p2 - p0) * tension
                    val cp2 = p2 - (p3 - p1) * tension

                    cubicTo(cp1.x, cp1.y, cp2.x, cp2.y, p2.x, p2.y)
                }
            }
        }

        val fillPath = Path().apply {
            addPath(smoothPath)
            lineTo(pts.last().x, h)
            lineTo(pts.first().x, h)
            close()
        }
        drawPath(
            path = fillPath,
            brush = Brush.verticalGradient(
                colors = listOf(lineColor.copy(alpha = 0.4f), gradientBottomColor),
                startY = 0f, endY = h
            )
        )

        drawPath(
            path = smoothPath,
            color = lineColor,
            style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
        )

        val sel = pts[selectedIndex]
        drawCircle(
            color = lineColor,
            radius = 8.dp.toPx(),
            center = sel,
            style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
        )
        drawCircle(
            color = Color.White,
            radius = 4.dp.toPx(),
            center = sel
        )
    }
}


@Preview
@Composable
private fun CwStockPreview() {
    MobileBankingTheme {
        Surface {
            CwStock(
                xAxis = listOf("Oct", "Nov", "Dec", "Jan", "Feb", "Mar"),
                yAxis = listOf(213.0, 6324.0, 42.0, 10123.0, 834.0, 124.0).map { it.toFloat() },
                balance = 1235.32,
                selected = 1,
                onSelectedChanged = { true })
        }
    }

}