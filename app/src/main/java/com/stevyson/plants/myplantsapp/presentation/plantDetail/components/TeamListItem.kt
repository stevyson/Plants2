package com.stevyson.plants.myplantsapp.presentation.plantDetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.stevyson.plants.myplantsapp.data.remote.dto.Hardiness

@Composable
fun TeamListItem(
    teamMember: Hardiness,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = teamMember.max,
            style = MaterialTheme.typography.displayMedium
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = teamMember.min,
            style = MaterialTheme.typography.displaySmall,
            fontStyle = FontStyle.Italic
        )
    }
}