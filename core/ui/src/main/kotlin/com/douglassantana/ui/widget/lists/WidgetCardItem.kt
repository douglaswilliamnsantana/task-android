package com.douglassantana.ui.widget.lists

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.douglassantana.ui.R

@Composable
fun WidgetCardItem(
    modifier: Modifier = Modifier,
    title: String
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = dimensionResource(id = R.dimen.default_margin),
                end = dimensionResource(id = R.dimen.default_margin),
                top = dimensionResource(id = R.dimen.default_margin)
            ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(id = R.dimen.default_elevation_card)
        )
    ) {
        Text(
            modifier = modifier
                .fillMaxWidth()
                .padding(all = dimensionResource(id = R.dimen.default_medium_margin)),
            style = MaterialTheme.typography.titleMedium,
            text = title
        )
    }
}