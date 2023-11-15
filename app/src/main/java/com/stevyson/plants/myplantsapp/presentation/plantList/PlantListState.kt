package com.stevyson.plants.myplantsapp.presentation.plantList

import com.stevyson.plants.myplantsapp.domain.model.Plant

data class PlantListState(
    val isLoading: Boolean = false,
    val plants: List<Plant>? = emptyList(),
    val error: String = ""
)
