package com.stevyson.plants.myplantsapp.domain.use_case.get_plants

import com.stevyson.plants.myplantsapp.common.Resource
import com.stevyson.plants.myplantsapp.data.remote.dto.toPlant
import com.stevyson.plants.myplantsapp.domain.model.Plant
import com.stevyson.plants.myplantsapp.domain.repository.PlantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPlantsUseCase @Inject constructor(
    private val repository: PlantRepository
) {
    operator fun invoke(): Flow<Resource<List<Plant>>> = flow {
        try {
            emit(Resource.Loading())
            val plants = repository.getPlants().data.map { it.toPlant() }
            emit(Resource.Success(plants))
        } catch(e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}