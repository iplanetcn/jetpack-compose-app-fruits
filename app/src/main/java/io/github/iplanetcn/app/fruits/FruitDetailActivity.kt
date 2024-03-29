package io.github.iplanetcn.app.fruits

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import io.github.iplanetcn.app.fruits.data.fruitData
import io.github.iplanetcn.app.fruits.ui.components.FruitDetailView
import io.github.iplanetcn.app.fruits.ui.theme.JetpackComposeAppFruitsTheme
import io.github.iplanetcn.app.fruits.utils.getSerializable
import java.util.*


class FruitDetailActivity : BaseActivity() {
    companion object {
        private const val EXTRA_FRUIT_UUID = "fruit_uuid"

        @JvmStatic
        fun start(context: Context, uuid: UUID) {
            val starter = Intent(context, FruitDetailActivity::class.java)
                .putExtra(EXTRA_FRUIT_UUID, uuid)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val uuid: UUID = intent.getSerializable(EXTRA_FRUIT_UUID, UUID::class.java)
        val fruit = fruitData.firstOrNull { fruit -> fruit.id == uuid }
        setupStatusBarColor(color = Color.Transparent)
        window?.run {
            WindowCompat.setDecorFitsSystemWindows(this, false)
        }
        setContent {
            JetpackComposeAppFruitsTheme {
                FruitDetailView(fruit!!)
            }
        }
    }
}

fun ComponentActivity.setupStatusBarColor(color: Color) {
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.statusBarColor = color.toArgb()
}


@Preview(name = "Light theme", uiMode = Configuration.UI_MODE_NIGHT_NO, showSystemUi = true)
@Preview(name = "Dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun Preview() {
    JetpackComposeAppFruitsTheme {
        FruitDetailView(fruitData.first())
    }
}