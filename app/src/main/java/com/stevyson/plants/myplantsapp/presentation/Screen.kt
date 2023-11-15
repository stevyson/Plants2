package com.stevyson.plants.myplantsapp.presentation

sealed class Screen(val route: String) {
    object PlantListScreen: Screen("plant_list_screen")
    object PlantDetailScreen: Screen("plant_detail_screen")
}
