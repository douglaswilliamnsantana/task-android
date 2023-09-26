package com.douglassantana.ui.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import com.douglassantana.ui.R

@Composable
fun TaskText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = TextAlign.Start
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = dimensionResource(id = R.dimen.default_margin)),
        style = MaterialTheme.typography.titleMedium,
        text = text,
        textAlign = textAlign
    )
}