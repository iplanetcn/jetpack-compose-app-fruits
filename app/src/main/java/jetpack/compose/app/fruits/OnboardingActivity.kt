package jetpack.compose.app.fruits

import android.os.Bundle
import android.util.DisplayMetrics
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
import jetpack.compose.app.fruits.utils.MetricsUtil
import jetpack.compose.app.fruits.view.FruitCardView

class OnboardingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = MetricsUtil.convertPixelsToDp(
            context = this,
            px = displayMetrics.widthPixels.toFloat()
        ).dp
        setContent {
            JetpackComposeAppFruitsTheme {
                // A surface container using the 'background' color from the theme
                OnboardingView(width)
            }
        }
    }
}

@Composable
fun OnboardingView(screenWidthInDp: Dp = 400.dp) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        val current = 0
        LazyRow {
            items(5) { index ->
                FruitCardView(fruit = fruitData[index], screenWidthInDp)
            }
        }

        LazyRow(
            modifier = Modifier.height(100.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top,
        ) {
            items(5) { index ->
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(
                            if (index == current) Color.White else Color.LightGray,
                            shape = CircleShape
                        )
                        .clip(CircleShape)
                )

                if (index < 4) {
                    Spacer(modifier = Modifier.size(10.dp))
                }
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