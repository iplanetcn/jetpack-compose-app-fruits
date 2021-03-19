package jetpack.compose.app.fruits

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import jetpack.compose.app.fruits.data.fruitData
import jetpack.compose.app.fruits.ui.components.FruitDetailView
import jetpack.compose.app.fruits.ui.theme.JetpackComposeAppFruitsTheme
import java.util.*


class FruitDetailActivity : ComponentActivity() {
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
        val uuid : UUID = intent.getSerializableExtra(EXTRA_FRUIT_UUID) as UUID
        val fruit = fruitData.firstOrNull { fruit -> fruit.id == uuid }

        setupStatusBarColor(color = fruit!!.gradientColors.first())
        setContent {
            JetpackComposeAppFruitsTheme {
                FruitDetailView(fruit)
            }
        }
    }
}

fun ComponentActivity.setupStatusBarColor(color: Color) {
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.statusBarColor = color.toArgb()
}