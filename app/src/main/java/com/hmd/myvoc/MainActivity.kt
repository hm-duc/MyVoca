package com.hmd.myvoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hmd.myvoc.presentation.add_vocabulary.AddVocabularyScreen
import com.hmd.myvoc.presentation.dashboard.DashboardScreen
import com.hmd.myvoc.presentation.my_vocabulary.MyVocabularyScreen
import com.hmd.myvoc.ui.navigation.Screen
import com.hmd.myvoc.ui.theme.MyVocTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyVocTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Dashboard,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable<Screen.Dashboard> {
                            DashboardScreen(
                                onNavigateToAdd = { navController.navigate(Screen.AddVocabulary) },
                                onNavigateToMyVoc = { navController.navigate(Screen.MyVocabulary) }
                            )
                        }
                        composable<Screen.AddVocabulary> {
                            AddVocabularyScreen(
                                onBack = { navController.popBackStack() }
                            )
                        }
                        composable<Screen.MyVocabulary> {
                            MyVocabularyScreen(
                                onBack = { navController.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}
