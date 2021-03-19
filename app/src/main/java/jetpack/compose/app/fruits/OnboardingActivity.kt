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
import jetpack.compose.app.fruits.ui.theme.JetpackComposeAppFruitsTheme
import jetpack.compose.app.fruits.view.FruitCardView

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
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        val current = 0
        val offset: Dp = 16.dp
        LazyRow(
            contentPadding = PaddingValues(offset),
            horizontalArrangement = Arrangement.spacedBy(offset)
        ) {
            items(5) { index ->
                FruitCardView(fruit = fruitData[index])
            }
        }
        
        val circleRadius = 10.dp
        LazyRow(
            modifier = Modifier.height(64.dp),
            horizontalArrangement = Arrangement.spacedBy(circleRadius),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            items(5) { index ->
                Box(
                    modifier = Modifier
                        .size(circleRadius)
                        .background(
                            if (index == current) Color.White else Color.LightGray,
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