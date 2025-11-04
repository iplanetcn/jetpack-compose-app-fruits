package io.github.iplanetcn.app.fruits.navigation

import android.net.Uri
import com.google.gson.Gson
import io.github.iplanetcn.app.fruits.data.Fruit

/**
 * Screen
 *
 * @author john
 * @since 2025-11-03
 */
sealed class Screen(val route: String) {
    data object Onboarding: Screen("onboarding")
    data object Main : Screen("home")
    data object Details : Screen("details/{fruitJson}") {
        fun createRoute(fruit: Fruit): String {
            val fruitJson = Uri.encode(Gson().toJson(fruit))
            return "details/$fruitJson"
        }
    }
    data object Settings : Screen("settings")
}