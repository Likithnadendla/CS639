package com.likith.myapplication.navigation

sealed class AppScreen(val route: String) {
    object Login : AppScreen("/login")
    object Products : AppScreen("/products/{category}")
    object Categories : AppScreen("/categories")
    object Cart : AppScreen("/cart")
    object OrderSuccess : AppScreen("/order-success")
}
