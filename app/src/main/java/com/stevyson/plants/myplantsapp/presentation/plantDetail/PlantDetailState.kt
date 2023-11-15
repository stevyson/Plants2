package com.stevyson.plants.myplantsapp.presentation.plantDetail

import com.stevyson.plants.myplantsapp.domain.model.PlantDetail


data class PlantDetailState(
    val isLoading: Boolean = false,
    val plant: PlantDetail? = null,
    val error: String = ""
)
