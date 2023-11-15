package com.stevyson.plants.myplantsapp.presentation.plantList.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.stevyson.plants.myplantsapp.domain.model.Plant

@Composable
fun PlantListItem(
    plant: Plant,
    onItemClick: (Plant) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(plant) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${plant.id}. ${plant.common_name} (${plant.scientific_name})",
            style = MaterialTheme.typography.titleLarge,
            overflow = TextOverflow.Ellipsis
        )

    }
}