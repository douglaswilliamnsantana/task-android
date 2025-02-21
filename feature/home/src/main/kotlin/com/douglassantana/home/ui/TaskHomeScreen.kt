package com.douglassantana.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.douglassantana.common.LifecycleAwareObserver
import com.douglassantana.common.ViewerUiResponse
import com.douglassantana.database.model.TaskEntity
import com.douglassantana.ui.theme.TaskTheme
import com.douglassantana.ui.widget.lists.TaskListIem
import com.douglassantana.designsystem.R as CoreUi

@Composable
internal fun TaskHomeRoute(
    modifier: Modifier = Modifier,
    navigateToTaskRegistration: () -> Unit,
) {

    val viewModel: TaskHomeViewModel = hiltViewModel()
    LifecycleAwareObserver(viewModel)

    val uiState = viewModel.uiState.collectAsStateWithLifecycle().value
    val taskRegistrationCallback by rememberUpdatedState(newValue = navigateToTaskRegistration)

    TaskHomeScreen(
        modifier = modifier,
        navigateToTaskRegistration = taskRegistrationCallback,
        uiState = uiState
    )
}

@Composable
internal fun TaskHomeScreen(
    modifier: Modifier = Modifier,
    navigateToTaskRegistration: () -> Unit,
    uiState: TaskHomeUiState
) = Scaffold(
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

        if (uiState.taskList.isEmpty()) {
            TaskHomeEmpty()
        } else {
            when(uiState.taskState) {
                is ViewerUiResponse.Success -> TaskHomeContent(tasks = uiState.taskList)
                is ViewerUiResponse.Error -> Unit
                is ViewerUiResponse.Loading -> Unit
            }
        }
    }
}

@Composable
private fun TaskHomeContent(
    modifier: Modifier = Modifier,
    tasks: List<TaskEntity>
) = Column {
    TaskHomeHeader()

    LazyColumn(
        modifier = modifier
            .padding(top = dimensionResource(id = CoreUi.dimen.default_margin))
    ) {
        items(items = tasks) { item ->
            TaskListIem(
                title = item.title,
                description = item.description
            )
        }
    }
}

@Composable
private fun TaskHomeEmpty(
    modifier: Modifier = Modifier,
) = Column(
    modifier = modifier.fillMaxSize()
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .padding(all = dimensionResource(id = CoreUi.dimen.default_margin))
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(id = CoreUi.string.my_task_empty),
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun TaskHomeHeader(
    modifier: Modifier = Modifier,
) = Column {
    Text(
        text = stringResource(id = CoreUi.string.hello_title),
        style = MaterialTheme.typography.titleLarge,
        modifier = modifier
            .padding(
                top = dimensionResource(id = CoreUi.dimen.default_height),
                start = dimensionResource(id = CoreUi.dimen.default_margin),
                end = dimensionResource(id = CoreUi.dimen.default_margin),
            )
            .fillMaxWidth()
    )

    Text(
        text = stringResource(id = CoreUi.string.manage_title),
        modifier = modifier
            .padding(
                top = dimensionResource(id = CoreUi.dimen.default_margin_xxsmall),
                start = dimensionResource(id = CoreUi.dimen.default_margin),
                end = dimensionResource(id = CoreUi.dimen.default_margin),
            )
            .fillMaxWidth()
    )
}

@Composable
@PreviewLightDark
private fun TaskHomePreview() {
    TaskTheme {
        TaskHomeScreen(
            navigateToTaskRegistration = {},
            uiState = TaskHomeUiState(
                taskList = listOf()
            ),
        )
    }
}