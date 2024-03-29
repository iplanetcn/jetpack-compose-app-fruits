package io.github.iplanetcn.app.fruits

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import io.github.iplanetcn.app.fruits.ui.theme.JetpackComposeAppFruitsTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RoutingActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        // Keep the splash screen visible for this Activity
        splashScreen.setKeepOnScreenCondition { true }
        setupStatusBarColor(color = Color.Transparent)
        window?.run {
            WindowCompat.setDecorFitsSystemWindows(this, false)
        }
        lifecycleScope.launch(Dispatchers.Main) {
            delay(1000)
            startActivity(Intent(this@RoutingActivity, OnboardingActivity::class.java))
            this@RoutingActivity.finish()
        }
    }
}

@Composable
fun SplashScreenView() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(colorResource(id = R.color.color_lime_dark))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            //FRUIT IMAGE
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "Content description for logo",
                modifier = Modifier.size(240.dp)
            )

            //FRUIT TITLE
            Text(
                text = stringResource(id = R.string.app_name),
                color = Color.White,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 48.sp,
                    letterSpacing = 0.15.sp
                ),
            )
        }
    }

}

@Preview(
    name = "Light Mode",
    showBackground = true)
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun DefaultPreview() {
    JetpackComposeAppFruitsTheme {
        SplashScreenView()
    }
}