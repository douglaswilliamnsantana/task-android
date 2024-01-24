package com.douglassantana.home.navigation

import com.douglassantana.common.NavigationDestination
import com.douglassantana.ui.R as CoreUi

object TaskHomeDestination : NavigationDestination {
    override val route = "task_registration"
    override val titleRes = CoreUi.string.app_name
}