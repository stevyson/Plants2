package com.stevyson.plants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stevyson.plants.myplantsapp.presentation.Screen
import com.stevyson.plants.myplantsapp.presentation.plantDetail.PlantDetailScreen
import com.stevyson.plants.myplantsapp.presentation.plantList.PlantListScreen
import com.stevyson.plants.ui.theme.PlantsTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlantsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.PlantListScreen.route
                    ) {
                        composable(
                            route = Screen.PlantListScreen.route
                        ) {
                            PlantListScreen(navController)
                        }
                        composable(
                            route = Screen.PlantDetailScreen.route + "/{plantId}"
                        ) {
                            PlantDetailScreen()
                        }
                    }
                }
            }
        }
    }
}

