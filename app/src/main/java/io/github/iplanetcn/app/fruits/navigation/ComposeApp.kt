package io.github.iplanetcn.app.fruits.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
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
import io.github.iplanetcn.app.fruits.ui.theme.JetpackComposeAppFruitsTheme

/**
 * ComposeApp
 *
 * @author john
 * @since 2025-11-03
 */
@Composable
fun ComposeApp() {
    val navController = rememberNavController()

    JetpackComposeAppFruitsTheme {
        NavHost(
            navController = navController,
            startDestination = Screen.Onboarding.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(300)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left, animationSpec = tween(300)
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right, animationSpec = tween(300)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.Right, animationSpec = tween(300)
                )
            }
        ) {
            composable(Screen.Onboarding.route) {
                OnboardingView(onNavigateToMain = {
                    // 使用popUpTo和inclusive参数来清除导航栈，这样更可靠
                    navController.navigate(Screen.Main.route) {
                        // 弹出到Onboarding路由
                        popUpTo(Screen.Onboarding.route) {
                            // 包含Onboarding路由本身，完全清除它
                            inclusive = true
                        }
                        // 确保不会在返回栈中多次添加Main路由
                        launchSingleTop = true
                    }
                })
            }

            composable(Screen.Main.route) {
                MainScreen(
                    toDetails = { fruit -> navController.navigate(Screen.Details.createRoute(fruit)) },
                    toSettings = { navController.navigate(Screen.Settings.route) }
                )
            }

            composable(
                Screen.Details.route,
                arguments = listOf(navArgument("fruitJson") { type = NavType.StringType })
            ) { backStackEntry ->
                val json = backStackEntry.arguments?.getString("fruitJson")
                val fruit = Gson().fromJson(json, Fruit::class.java)
                FruitDetailView(fruit = fruit, onBack = {
                    navController.popBackStack()
                })
            }

            composable(Screen.Settings.route) {
                SettingsView(onClose = {
                    navController.popBackStack()
                })
            }
        }
    }
}