package com.douglassantana.task.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.douglassantana.home.navigation.HomeRoute
import com.douglassantana.home.navigation.navigateToHome
import com.douglassantana.home.navigation.taskHomeScreen
import com.douglassantana.register.navigation.navigateToTaskRegister
import com.douglassantana.register.navigation.taskRegisterScreen

@Composable
fun TaskNavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
) = NavHost(
    navController = navController,
    startDestination = HomeRoute,
    modifier = modifier
) {
    taskHomeScreen(
        onNavigateRegisterTask = navController::navigateToTaskRegister
    )

    taskRegisterScreen(
        onNavigateHome = navController::navigateToHome
    )
}