package com.example.mobilebanking.presentation.screen.on_boarding

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilebanking.R
import com.example.mobilebanking.presentation.design_system.button.CwButton
import com.example.mobilebanking.presentation.design_system.progress_dots.ProgressDotRow
import com.example.mobilebanking.ui.theme.Black100
import com.example.mobilebanking.ui.theme.Gray100
import com.example.mobilebanking.ui.theme.MobileBankingTheme

@Composable
fun OnBoardingContent(
    modifier: Modifier = Modifier,
    @DrawableRes photo: Int,
    count: Int,
    mainText: String,
    subText: String,
    onClick: () -> Unit,
    isSelected: (Int) -> Boolean,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Image(
            painter = painterResource(photo),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProgressDotRow(
                modifier = Modifier
                    .height(6.dp)
                    .align(Alignment.CenterHorizontally),
                count = count
            ) { isSelected(it) }


            Text(
                text = mainText,
                color = Black100,
                fontSize = 26.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = subText,
                color = Gray100,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )


            CwButton(
                text = "Next",
                onClick = onClick,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
private fun OnBoardingBottomContentPreview() {
    MobileBankingTheme {

        Surface {
            OnBoardingContent(
                modifier = Modifier,
                photo = R.drawable.ic_on_boarding_entry,
                count = 3,
                "safdsfdsf",
                "sdfkldsjfdsklf",
                {},
                { it == 0 })
        }
    }

}