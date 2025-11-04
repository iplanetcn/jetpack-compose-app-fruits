package io.github.iplanetcn.app.fruits.ui.screen

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.iplanetcn.app.fruits.data.fruitData
import io.github.iplanetcn.app.fruits.ui.components.FruitDetailView
import io.github.iplanetcn.app.fruits.ui.theme.JetpackComposeAppFruitsTheme


@Preview(name = "Light theme", uiMode = Configuration.UI_MODE_NIGHT_NO, showSystemUi = true)
@Preview(name = "Dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun FruitDetailViewPreview() {
    JetpackComposeAppFruitsTheme {
        FruitDetailView(fruitData.first())
    }
}