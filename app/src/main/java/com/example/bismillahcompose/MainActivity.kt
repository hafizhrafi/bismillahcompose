package com.example.bismillahcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bismillahcompose.Screens.DetailScreen
import com.example.bismillahcompose.Screens.MainScreen
import com.example.bismillahcompose.Screens.ProfileScreen
import com.example.bismillahcompose.ui.theme.BismillahcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BismillahcomposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val imageId = arrayOf(
                        R.drawable.p1,
                        R.drawable.p2,
                        R.drawable.p3,
                        R.drawable.p4,
                        R.drawable.p5,
                        R.drawable.p6,
                        R.drawable.p7,
                        R.drawable.p8,
                        R.drawable.p9,
                        R.drawable.p10
                    )

                    val names = arrayOf(
                        "w175",
                        "spotster",
                        "w250",
                        "RE 350",
                        "XS 650",
                        "Beat Balap",
                        "Fazio",
                        "Filano",
                        "PE 250",
                        "onthel"
                    )

                    val detail = arrayOf(
                        "w175 dengan 175 cc nya",
                        "spotster dengan buatan harley davdidson",
                        "w250 dari kawasaki",
                        "Royal Enfield dengan classicnya",
                        "XS 650 dengan cc 650",
                        "Beat spek balap harian",
                        "keluaran terbau yamaha",
                        "kakak dari fazio",
                        "beneli seri pe 250 ",
                        "ini adalah kendaraan para pejuang indonesia"

                    )


                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "MainScreen") {
                        composable(route = "MainScreen") {
                            MainScreen(imageId, names, navController)
                        }
                        composable(route = "DetailScreen/{index}",
                            arguments = listOf(
                                navArgument(name = "index") {
                                    type = NavType.IntType
                                }
                            )
                        ) { index->
                            DetailScreen(
                                photos = imageId,
                                names = names,
                                detail = detail,
                                itemIndex = index.arguments?.getInt("index")
                            )
                        }
                        composable(route = "Profile"){
                            ProfileScreen(navController)
                        }
                    }
                }
            }
        }
    }
}
