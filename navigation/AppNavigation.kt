package com.likith.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.likith.myapplication.view.screens.CartScreen
import com.likith.myapplication.view.screens.CategoryScreen
import com.likith.myapplication.view.screens.LoginPage
import com.likith.myapplication.view.screens.OrderSuccessScreen
import com.likith.myapplication.view.screens.ProductsScreen


@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppScreen.Login.route
    ) {
        composable(AppScreen.Login.route) {
            LoginPage(onLoginSuccess = {
                navController.navigate(
                    AppScreen.Categories.route
                )
            })
        }
        composable(AppScreen.Products.route + "/{category}") {
            val category = it.arguments?.getString("category") ?: ""
            ProductsScreen(category= category) {
                navController.navigate(
                    AppScreen.Cart.route
                )
            }
        }

        composable(AppScreen.Categories.route) {
            CategoryScreen {
                navController.navigate(
                    AppScreen.Products.route + "/${it}"
                )
            }
        }

        composable(AppScreen.Cart.route) {
            CartScreen {
                navController.navigate(
                    AppScreen.OrderSuccess.route
                )
            }
        }
        composable(AppScreen.OrderSuccess.route) {
            OrderSuccessScreen {
                navController.navigate(
                    AppScreen.Categories.route
                )
            }
        }
    }
}
