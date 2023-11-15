package com.stevyson.plants.myplantsapp.domain.repository

import com.stevyson.plants.myplantsapp.data.remote.dto.PlantDetailDto
import com.stevyson.plants.myplantsapp.data.remote.dto.PlantsResponse


interface PlantRepository {

    suspend fun getPlants(): PlantsResponse

    suspend fun getPlantById(plantId: String): PlantDetailDto

}