package com.douglassantana.register.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.douglassantana.register.ui.TaskRegisterRoute
import kotlinx.serialization.Serializable

@Serializable
data object RegisterRoute

fun NavController.navigateToTaskRegister(
    navOptions: NavOptions? = null
) = navigate(RegisterRoute, navOptions)

fun NavGraphBuilder.taskRegisterScreen(
    onNavigateHome: () -> Unit
) = composable<RegisterRoute> {
    TaskRegisterRoute(
        onNavigateHome = onNavigateHome
    )
}