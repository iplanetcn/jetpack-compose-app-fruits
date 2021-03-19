package jetpack.compose.app.fruits

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import jetpack.compose.app.fruits.data.fruitData
import jetpack.compose.app.fruits.ui.components.FruitCardView
import jetpack.compose.app.fruits.ui.theme.JetpackComposeAppFruitsTheme

class OnboardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAppFruitsTheme {
                OnboardingView()
            }
        }
    }
}

@Composable
fun OnboardingView() {
    val count = 6
    val current = 0
    val offset: Dp = 16.dp
    val circleRadius = 8.dp

    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        LazyRow(
            contentPadding = PaddingValues(offset),
            horizontalArrangement = Arrangement.spacedBy(offset)
        ) {
            items(count) { index ->
                FruitCardView(fruit = fruitData[index])
            }
        }

        LazyRow(
            modifier = Modifier.height(64.dp),
            horizontalArrangement = Arrangement.spacedBy(circleRadius),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items(count) { index ->
                Box(
                    modifier = Modifier
                        .size(circleRadius)
                        .background(
                            if (index == current) Color.White else Color(0x40FFFFFF),
                            shape = CircleShape
                        )
                        .clip(CircleShape)
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun OnboardingViewPreview() {
    JetpackComposeAppFruitsTheme {
        OnboardingView()
    }
}