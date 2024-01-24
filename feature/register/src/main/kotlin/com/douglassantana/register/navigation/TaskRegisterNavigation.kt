package com.douglassantana.register.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.douglassantana.register.ui.TaskRegisterRoute

fun NavController.navigateToRegister(
    destination: String,
    navOptions: NavOptions? = null
) {
    this.navigate(destination, navOptions)
}

fun NavGraphBuilder.taskRegisterScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
) {
    composable(route = TaskRegisterDestination.route) {
        TaskRegisterRoute(
            navigateBack = navigateBack,
            onNavigateUp = onNavigateUp
        )
    }
}