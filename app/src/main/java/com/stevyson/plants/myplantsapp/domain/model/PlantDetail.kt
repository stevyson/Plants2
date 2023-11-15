package com.stevyson.plants.myplantsapp.domain.model

import com.stevyson.plants.myplantsapp.data.remote.dto.DefaultImageX
import com.stevyson.plants.myplantsapp.data.remote.dto.Hardiness

data class PlantDetail(
    val careGuides: String,
    val care_level: String,
    val common_name: String,
    val default_image: DefaultImageX? = null,
    val description: String,
    val dimension: String,
    val growth_rate: String,
    val hardiness: Hardiness,
    val plantId: Int,
    val indoor: Boolean,
    val maintenance: String,
    val origin: List<String>,
    val other_images: String,
    val other_name: List<Any>,
    val pest_susceptibility: List<String>,
    val poisonous_to_pets: Int,
    val scientific_name: List<String>,
    val sunlight: List<String>,
    val watering: String,
    val watering_period: String
)