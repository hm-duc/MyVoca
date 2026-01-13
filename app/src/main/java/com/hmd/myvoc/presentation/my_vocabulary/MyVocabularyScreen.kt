package com.hmd.myvoc.presentation.my_vocabulary

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.hmd.myvoc.domain.model.Vocabulary

@Composable
fun MyVocabularyScreen(
    onBack: () -> Unit,
    viewModel: MyVocabularyViewModel = hiltViewModel()
) {
    val vocabularies by viewModel.vocabularies.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "My Vocabulary", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(vocabularies) { vocabulary ->
                VocabularyItem(vocabulary)
            }
        }
    }
}

@Composable
fun VocabularyItem(vocabulary: Vocabulary) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = vocabulary.word, style = MaterialTheme.typography.titleMedium)
            Text(text = vocabulary.meaning, style = MaterialTheme.typography.bodyMedium)
            vocabulary.example?.let {
                Text(
                    text = "Example: $it",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}