package io.github.iplanetcn.app.fruits.ui.screen

import android.content.res.Configuration
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
import io.github.iplanetcn.app.fruits.R
import io.github.iplanetcn.app.fruits.ui.theme.JetpackComposeAppFruitsTheme

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
fun SplashScreenViewPreview() {
    JetpackComposeAppFruitsTheme {
        SplashScreenView()
    }
}