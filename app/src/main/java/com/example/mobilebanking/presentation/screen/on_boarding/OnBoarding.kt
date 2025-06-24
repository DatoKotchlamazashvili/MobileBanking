package com.example.mobilebanking.presentation.screen.on_boarding

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobilebanking.R
import com.example.mobilebanking.ui.theme.MobileBankingTheme
import kotlinx.coroutines.launch

data class OnboardingPage(
    @DrawableRes val image: Int,
    val title: String,
    val subtitle: String,
)

@Composable
fun OnBoarding(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(pageCount = { pages.size })
    val coroutineScope = rememberCoroutineScope()

    HorizontalPager(state = pagerState, modifier = modifier) { page ->
        val screenParams = pages[page]
        OnBoardingContent(
            modifier = Modifier.fillMaxSize(),
            photo = screenParams.image,
            count = pages.size,
            mainText = screenParams.title,
            subText = screenParams.subtitle,
            onClick = {
                coroutineScope.launch {
                    if (page < pages.lastIndex) {
                        pagerState.animateScrollToPage(page + 1)
                    } else {

                    }
                }
            },
            isSelected = { page == it }
        )
    }
}


private val pages = listOf(
    OnboardingPage(
        image = R.drawable.ic_on_boarding_entry,
        title = "Fastest Payment in the World",
        subtitle = "Integrate multiple payment methods to speed up your process"
    ),
    OnboardingPage(
        image = R.drawable.ic_on_boarding_mid,
        title = "Secure Wallet",
        subtitle = "Your funds are protected with bank-grade encryption"
    ),
    OnboardingPage(
        image = R.drawable.ic_on_boarding_last,
        title = "Easy Tracking",
        subtitle = "Keep track of payments, receipts, and history in one place"
    )
)

@Preview(showBackground = true)
@Composable
fun OnboardingPagerPreview() {
    MobileBankingTheme {
        Surface {
            OnBoarding()
        }
    }
}