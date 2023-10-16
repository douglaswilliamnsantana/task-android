package com.douglassantana.home.ui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.douglassantana.domain.model.TaskModel
import com.douglassantana.ui.R as CoreUi
import com.douglassantana.ui.widget.TaskText
import org.koin.androidx.compose.getViewModel

@Composable
internal fun TaskHomeRoute(
    modifier: Modifier = Modifier,
    navigateToTaskRegistration: () -> Unit,
    viewModel: TaskHomeViewModel = getViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val error by viewModel.error.collectAsState()

    TaskHomeScreen(
        modifier = modifier,
        navigateToTaskRegistration = navigateToTaskRegistration,
        uiState = uiState,
        error = error
    )
}

@Composable
internal fun TaskHomeScreen(
    modifier: Modifier = Modifier,
    navigateToTaskRegistration: () -> Unit,
    uiState: TaskHomeScreenState,
    error: Boolean
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navigateToTaskRegistration() },
                content = {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = stringResource(id = CoreUi.string.app_name)
                    )
                }
            )
        }
    ) { paddingValues ->
        Surface(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            if (error)
                Toast.makeText(
                    LocalContext.current,
                    stringResource(id = CoreUi.string.default_error_title),
                    Toast.LENGTH_LONG
                ).show()

            if (uiState.taskList.isEmpty()) {
                TaskHomeEmpty()
            } else {
                TaskHomeBody(tasks = uiState.taskList)
            }
        }
    }
}

@Composable
private fun TaskHomeBody(
    modifier: Modifier = Modifier,
    tasks: List<TaskModel>
) {
    Column {
        TaskText(text = stringResource(id = CoreUi.string.my_task_title))

        LazyColumn(modifier = modifier) {
            items(items = tasks) { item ->
                TaskHomeItem(taskName = item.name)
            }
        }
    }
}

@Composable
private fun TaskHomeEmpty(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TaskText(
                text = stringResource(id = CoreUi.string.my_task_empty),
                textAlign = TextAlign.Center
            )
        }
    }
}