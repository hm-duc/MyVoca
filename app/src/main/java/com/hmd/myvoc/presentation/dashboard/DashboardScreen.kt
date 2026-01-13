package com.hmd.myvoc.presentation.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DashboardScreen(
    onNavigateToAdd: () -> Unit,
    onNavigateToMyVoc: () -> Unit,
    viewModel: DashboardViewModel = hiltViewModel()
) {
    val totalCount by viewModel.totalCount.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Dashboard", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Total Vocabularies: $totalCount", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onNavigateToAdd, modifier = Modifier.fillMaxWidth()) {
            Text("Add Vocabulary")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onNavigateToMyVoc, modifier = Modifier.fillMaxWidth()) {
            Text("My Vocabulary")
        }
    }
}