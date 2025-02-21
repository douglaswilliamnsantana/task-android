package com.douglassantana.ui.widget.header

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.douglassantana.designsystem.R
import com.douglassantana.ui.theme.TaskTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskHeader(
    title: String,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
) = CenterAlignedTopAppBar(
    title = {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium
        )
    },
    modifier = modifier,
    scrollBehavior = scrollBehavior,
    navigationIcon = {
        IconButton(onClick = navigateUp) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = stringResource(R.string.app_name)
            )
        }
    }
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@PreviewLightDark
private fun TaskHeaderPreview() {
    TaskTheme {
        TaskHeader(
            title = stringResource(R.string.app_name),
            navigateUp = {}
        )
    }
}