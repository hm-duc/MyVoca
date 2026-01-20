package com.hmd.myvoc.presentation.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hmd.myvoc.ui.theme.MyVocTheme

@Composable
fun DashboardScreen(
    onNavigateToAdd: () -> Unit,
    onNavigateToMyVoc: () -> Unit,
    viewModel: DashboardViewModel = hiltViewModel()
) {
    val totalCount by viewModel.totalCount.collectAsState()

    DashboardContent(
        totalCount = totalCount,
        onNavigateToAdd = onNavigateToAdd,
        onNavigateToMyVoc = onNavigateToMyVoc
    )
}

@Composable
fun DashboardContent(
    totalCount: Int,
    onNavigateToAdd: () -> Unit,
    onNavigateToMyVoc: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.height(50.dp)
                .fillMaxWidth()

                .padding(20.dp),
            horizontalAlignment = Alignment.Start,
        ) { }
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    MyVocTheme {
        Surface {
            DashboardContent(
                totalCount = 12,
                onNavigateToAdd = {},
                onNavigateToMyVoc = {}
            )
        }
    }
}