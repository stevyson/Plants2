package com.stevyson.plants.myplantsapp.domain.use_case.get_plant

import com.stevyson.plants.myplantsapp.common.Resource
import com.stevyson.plants.myplantsapp.data.remote.dto.toPlantDetail
import com.stevyson.plants.myplantsapp.domain.model.PlantDetail
import com.stevyson.plants.myplantsapp.domain.repository.PlantRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPlantUseCase @Inject constructor(
    private val repository: PlantRepository
) {
    operator fun invoke(plantId: String): Flow<Resource<PlantDetail>> = flow {
        try {
            emit(Resource.Loading<PlantDetail>())
            val plant = repository.getPlantById(plantId).toPlantDetail()
            emit(Resource.Success<PlantDetail>(plant))
        } catch(e: HttpException){
            emit(Resource.Error<PlantDetail>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException){
            emit(Resource.Error<PlantDetail>("Couldn't reach server. Check your internet connection"))
        }
    }
}