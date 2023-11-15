package com.stevyson.plants.myplantsapp.domain.model

import com.stevyson.plants.myplantsapp.data.remote.dto.DefaultImage

data class Plant(
    val common_name: String,
    val default_image: DefaultImage? = null,
    val id: Int,
    val scientific_name: List<String>,
)
