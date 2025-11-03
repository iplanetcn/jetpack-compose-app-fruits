package io.github.iplanetcn.app.fruits.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import io.github.iplanetcn.app.fruits.data.Fruit
import io.github.iplanetcn.app.fruits.ui.components.FruitDetailView
import io.github.iplanetcn.app.fruits.ui.screen.MainScreen
import io.github.iplanetcn.app.fruits.ui.screen.OnboardingView
import io.github.iplanetcn.app.fruits.ui.screen.SettingsView
import kotlin.jvm.java

/**
 * FruitApp
 *
 * @author john
 * @since 2025-11-03
 */
@Composable
fun FruitApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Onboarding.route
    ) {
        composable(Screen.Onboarding.route) {
            OnboardingView(onNavigateToMain = {
                navController.navigate(Screen.Main.route)
                navController.clearBackStack<Composable>()
            })
        }

        composable(Screen.Main.route) {
            MainScreen(
                toDetails = { fruit -> navController.navigate(Screen.Details.createRoute(fruit)) },
                toSettings = { navController.navigate(Screen.Settings.route) }
            )
        }

        composable(Screen.Details.route, arguments = listOf(navArgument("fruitJson") { type = NavType.StringType })) {
                backStackEntry ->
            val json = backStackEntry.arguments?.getString("fruitJson")
            val fruit = Gson().fromJson(json, Fruit::class.java)
            FruitDetailView(fruit = fruit)
        }

        composable(Screen.Settings.route) {
            SettingsView(onClose = {
                navController.popBackStack()
            })
        }
    }
}