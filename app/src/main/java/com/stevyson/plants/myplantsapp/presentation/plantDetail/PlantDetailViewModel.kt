package com.stevyson.plants.myplantsapp.presentation.plantDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stevyson.plants.myplantsapp.common.Constants
import com.stevyson.plants.myplantsapp.common.Resource
import com.stevyson.plants.myplantsapp.domain.use_case.get_plant.GetPlantUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PlantDetailViewModel @Inject constructor(
    private val getPlantUseCase: GetPlantUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(PlantDetailState())
    val state: State<PlantDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_PLANT_ID)?.let { plantId ->
            getPlant(plantId.toString())
        }
    }

    private fun getPlant(plantId: String) {
        getPlantUseCase(plantId.toString()).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PlantDetailState(plant = result.data)
                }
                is Resource.Error -> {
                    _state.value = PlantDetailState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = PlantDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}