package com.hmd.myvoc.presentation.add_vocabulary

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AddVocabularyScreen(
    onBack: () -> Unit,
    viewModel: AddVocabularyViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Add Vocabulary", style = MaterialTheme.typography.headlineMedium)
        
        OutlinedTextField(
            value = viewModel.word,
            onValueChange = { viewModel.word = it },
            label = { Text("Word") },
            modifier = Modifier.fillMaxWidth()
        )
        
        OutlinedTextField(
            value = viewModel.meaning,
            onValueChange = { viewModel.meaning = it },
            label = { Text("Meaning") },
            modifier = Modifier.fillMaxWidth()
        )
        
        OutlinedTextField(
            value = viewModel.example,
            onValueChange = { viewModel.example = it },
            label = { Text("Example (Optional)") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = { viewModel.saveVocabulary(onBack) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save")
        }
    }
}