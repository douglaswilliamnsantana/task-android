package com.douglassantana.task.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.douglassantana.task.navigation.TaskNavHost
import com.douglassantana.task.ui.theme.TaskTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskTheme {
                TaskNavHost(navController = rememberNavController())
            }
        }
    }
}