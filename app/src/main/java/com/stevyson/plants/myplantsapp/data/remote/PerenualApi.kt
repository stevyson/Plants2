package com.stevyson.plants.myplantsapp.data.remote

import com.stevyson.plants.myplantsapp.data.remote.dto.PlantDetailDto
import com.stevyson.plants.myplantsapp.data.remote.dto.PlantsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PerenualApi {

    @GET("api/species-list?key=sk-13ed6551ab16cddbb2938")
    suspend fun getPlants(): PlantsResponse

    @GET("api/species/details/{plantId}?key=sk-13ed6551ab16cddbb2938")
    suspend fun getPlantById(@Path("plantId") plantId: String): PlantDetailDto

}