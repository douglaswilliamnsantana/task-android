package com.douglassantana.register.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.douglassantana.home.navigation.navigateToHome
import com.douglassantana.ui.theme.TaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskRegisterActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController: NavController = rememberNavController()

            TaskTheme {
                TaskRegisterRoute(
                    onNavigateHome = navController::navigateToHome
                )
            }
        }
    }
}