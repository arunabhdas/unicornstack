package app.unicornapp.mobile.android.unicorn.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import app.unicornapp.mobile.android.unicorn.ui.screens.ContactScreen
import app.unicornapp.mobile.android.unicorn.ui.screens.HomeScreen
import app.unicornapp.mobile.android.unicorn.ui.screens.HomeDetailScreen
import app.unicornapp.mobile.android.unicorn.ui.screens.NotificationScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(
            route = Screen.HomeScreen.route
        ) {
            HomeScreen(
                navController = navController
            )
        }

        composable(
            route = Screen.HomeDetailScreen.route
        ) {
            HomeDetailScreen(
                navController = navController
            )
        }

        composable(
            route = Screen.NotificationScreen.route
        ) {
            NotificationScreen(
                navController = navController
            )
        }

        composable(
            route = Screen.ContactScreen.route
        ) {
            ContactScreen(
                navController = navController
            )
        }
    }
}