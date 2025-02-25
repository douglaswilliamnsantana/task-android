package com.douglassantana.ui.widget.lists

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.douglassantana.common.isNotNullOrEmpty
import com.douglassantana.designsystem.R
import com.douglassantana.ui.theme.TaskTheme

@Composable
fun TaskListIem(
    title: String? = null,
    description: String? = null,
    modifier: Modifier = Modifier,
) = Card(
    modifier = modifier
        .fillMaxWidth()
        .padding(
            start = dimensionResource(id = R.dimen.default_margin),
            end = dimensionResource(id = R.dimen.default_margin),
            top = dimensionResource(id = R.dimen.default_xxmargin)
        )
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = dimensionResource(id = R.dimen.default_margin))
    ) {
        title.takeIf { it.isNotNullOrEmpty() }?.let { title ->
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                modifier = modifier.fillMaxWidth()
            )
        }

        description.takeIf { it.isNotNullOrEmpty() }?.let { description ->
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(id = R.dimen.default_margin_xxsmall))
            )
        }
    }
}

@Composable
@PreviewLightDark
private fun TaskListItemPreview() {
    TaskTheme {
        Surface {
            LazyColumn {
                items(count = 5) {
                    TaskListIem(
                        title = "Product Design",
                        description = "Design a Finance mobile app"
                    )
                }
            }
        }
    }
}