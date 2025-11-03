package io.github.iplanetcn.app.fruits.ui.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.iplanetcn.app.fruits.R
import io.github.iplanetcn.app.fruits.data.fruitData
import io.github.iplanetcn.app.fruits.ui.components.FruitCardView
import io.github.iplanetcn.app.fruits.ui.components.HorizontalPagerIndicator
import io.github.iplanetcn.app.fruits.ui.theme.JetpackComposeAppFruitsTheme

@Composable
fun OnboardingView(onNavigateToMain: () -> Unit) {
    val pagerState = rememberPagerState { 6 }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.matchParentSize(),
        ) { page ->
            // 页面内容展示
            FruitCardView(fruit = fruitData[page], onNavigateToMain)
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 48.dp),
            activeColor = colorResource(R.color.white)
        )
    }
}

@Preview(
    name = "Light Mode",
    showBackground = true
)
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun OnboardingViewPreview() {
    JetpackComposeAppFruitsTheme {
        OnboardingView {}
    }
}