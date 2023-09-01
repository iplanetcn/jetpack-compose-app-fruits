package io.github.iplanetcn.app.fruits

import android.content.Context
import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import io.github.iplanetcn.app.fruits.data.fruitData
import io.github.iplanetcn.app.fruits.ui.components.FruitRowView
import io.github.iplanetcn.app.fruits.ui.theme.JetpackComposeAppFruitsTheme
import io.github.iplanetcn.app.fruits.ui.theme.Typography

class MainActivity : BaseActivity() {
    companion object {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, MainActivity::class.java)
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupStatusBarColor(color = Color.Transparent)
        window?.run {
            WindowCompat.setDecorFitsSystemWindows(this, false)
        }
        setContent {
            JetpackComposeAppFruitsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainView()
                }
            }
        }
    }
}

@Composable
fun MainAppBar() {
    val context = LocalContext.current

    TopAppBar(
        modifier = Modifier.padding(top = 32.dp),
        elevation = 0.dp,
    ) {
        Text(
            text = "Fruits",
            textAlign = TextAlign.Center,
            style = Typography.h4,
            modifier = Modifier
                .padding(8.dp)
                .wrapContentSize(Alignment.Center)
        )

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = {
            SettingsActivity.start(context)
        }) {
            Icon(imageVector = Icons.Default.Settings, contentDescription = "")
        }
    }
}

@Composable
fun MainView() {
    Scaffold(
        topBar = { MainAppBar() }
    ) {
        LazyColumn(Modifier.padding(it)) {
            items(fruitData) { item ->
                FruitRowView(fruit = item)
            }
        }
    }
}

@Preview(name = "Light theme", uiMode = UI_MODE_NIGHT_NO, showSystemUi = true)
@Preview(name = "Dark theme", uiMode = UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun MainViewPreview() {
    JetpackComposeAppFruitsTheme {
        MainView()
    }
}