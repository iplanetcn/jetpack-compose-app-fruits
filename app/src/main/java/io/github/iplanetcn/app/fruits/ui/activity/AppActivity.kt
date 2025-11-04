package io.github.iplanetcn.app.fruits.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import io.github.iplanetcn.app.fruits.navigation.ComposeApp
import io.github.iplanetcn.app.fruits.viewmodel.AppViewModel

/**
 * AppActivity
 *
 * @author john
 * @since 2025-11-03
 */
@AndroidEntryPoint
class AppActivity: ComponentActivity() {
    private val viewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        window?.run {
            WindowCompat.setDecorFitsSystemWindows(this, false)
        }
        splashScreen.setKeepOnScreenCondition { viewModel.isLoading.value }
        setContent { ComposeApp() }
    }
}