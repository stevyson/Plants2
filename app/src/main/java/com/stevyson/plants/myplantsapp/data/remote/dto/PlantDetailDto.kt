package com.stevyson.plants.myplantsapp.data.remote.dto

import com.squareup.moshi.JsonClass
import com.stevyson.plants.myplantsapp.domain.model.PlantDetail


@JsonClass(generateAdapter = true)
data class PlantDetailDto(
    val attracts: List<Any>,
    val careGuides: String,
    val care_level: String,
    val common_name: String,
    val cones: Boolean,
    val cuisine: Boolean,
    val cycle: String,
    val default_image: DefaultImageX? = null,
    val depth_water_requirement: List<Any>,
    val description: String,
    val dimension: String,
    val dimensions: Dimensions,
    val drought_tolerant: Boolean,
    val edible_fruit: Boolean,
    val edible_fruit_taste_profile: String,
    val edible_leaf: Boolean,
    val family: String,
    val flower_color: String,
    val flowering_season: String,
    val flowers: Boolean,
    val fruit_color: List<String>,
    val fruit_nutritional_value: String,
    val fruits: Boolean,
    val growth_rate: String,
    val hardiness: Hardiness,
    val hardiness_location: HardinessLocation,
    val harvest_season: String,
    val id: Int,
    val indoor: Boolean,
    val invasive: Boolean,
    val leaf: Boolean,
    val leaf_color: List<String>,
    val maintenance: String,
    val medicinal: Boolean,
    val origin: List<String>,
    val other_images: String,
    val other_name: List<Any>,
    val pest_susceptibility: List<String>,
    val pest_susceptibility_api: String,
    val plant_anatomy: List<Any>,
    val poisonous_to_humans: Int,
    val poisonous_to_pets: Int,
    val propagation: List<String>,
    val pruning_count: List<Any>,
    val pruning_month: List<String>,
    val salt_tolerant: Boolean,
    val scientific_name: List<String>,
    val seeds: Int,
    val soil: List<String>,
    val sunlight: List<String>,
    val thorny: Boolean,
    val tropical: Boolean,
    val type: String,
    val volume_water_requirement: List<Any>,
    val watering: String,
    val watering_general_benchmark: WateringGeneralBenchmark,
    val watering_period: String
)


fun PlantDetailDto.toPlantDetail(): PlantDetail {
    return PlantDetail(
        careGuides = careGuides,
        care_level = care_level,
        common_name = common_name,
        default_image = default_image,
        description = description,
        dimension = dimension,
        growth_rate = growth_rate,
        hardiness = hardiness,
        plantId = id,
        indoor = indoor,
        maintenance = maintenance,
        origin = origin,
        other_images = other_images,
        other_name = other_name,
        pest_susceptibility = pest_susceptibility,
        poisonous_to_pets = poisonous_to_pets,
        scientific_name = scientific_name,
        sunlight = sunlight,
        watering = watering,
        watering_period = watering_period
    )
}