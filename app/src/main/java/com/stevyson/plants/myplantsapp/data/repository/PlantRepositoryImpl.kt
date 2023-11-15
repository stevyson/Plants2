package com.stevyson.plants.myplantsapp.data.repository

import com.stevyson.plants.myplantsapp.data.remote.PerenualApi
import com.stevyson.plants.myplantsapp.data.remote.dto.PlantDetailDto
import com.stevyson.plants.myplantsapp.data.remote.dto.PlantsResponse
import com.stevyson.plants.myplantsapp.domain.repository.PlantRepository
import javax.inject.Inject

class PlantRepositoryImpl @Inject constructor(
    private val api: PerenualApi
) : PlantRepository {
    override suspend fun getPlants(): PlantsResponse {
        return api.getPlants()
    }

    override suspend fun getPlantById(plantId: String): PlantDetailDto {
        return api.getPlantById(plantId)
    }

}