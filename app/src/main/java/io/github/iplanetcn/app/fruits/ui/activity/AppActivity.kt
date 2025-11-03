package io.github.iplanetcn.app.fruits.ui.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import io.github.iplanetcn.app.fruits.navigation.FruitApp
import io.github.iplanetcn.app.fruits.ui.screen.setupStatusBarColor
import io.github.iplanetcn.app.fruits.ui.theme.JetpackComposeAppFruitsTheme
import io.github.iplanetcn.app.fruits.viewmodel.AppViewModel

/**
 * AppActivity
 *
 * @author john
 * @since 2025-11-03
 */
@AndroidEntryPoint
class AppActivity: BaseActivity() {
    private val appViewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Keep the splash screen visible for this Activity
        setupStatusBarColor(color = Color.Transparent)
        window?.run {
            WindowCompat.setDecorFitsSystemWindows(this, false)
        }
        setContent {
            JetpackComposeAppFruitsTheme {
                FruitApp()
            }
        }
    }
}