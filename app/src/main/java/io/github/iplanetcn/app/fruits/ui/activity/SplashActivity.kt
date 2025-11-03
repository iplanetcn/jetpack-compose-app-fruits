package io.github.iplanetcn.app.fruits.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.result.launch
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import io.github.iplanetcn.app.fruits.ui.screen.SplashScreenView
import io.github.iplanetcn.app.fruits.ui.theme.JetpackComposeAppFruitsTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * SplashActivity
 *
 * @author john
 * @since 2025-11-03
 */
@AndroidEntryPoint
class SplashActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeAppFruitsTheme {
                SplashScreenView()
            }
        }

        // Use lifecycleScope to navigate after a delay
        lifecycleScope.launch {
            delay(2000) // Keep the splash screen for 2 seconds

            // Navigate to your main activity
            startActivity(Intent(this@SplashActivity, AppActivity::class.java))

            // Finish SplashActivity so the user can't go back to it
            finish()
        }
    }
}