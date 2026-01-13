package com.hmd.myvoc.presentation.add_vocabulary

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hmd.myvoc.domain.model.Vocabulary
import com.hmd.myvoc.domain.repository.VocabularyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddVocabularyViewModel @Inject constructor(
    private val repository: VocabularyRepository
) : ViewModel() {

    var word by mutableStateOf("")
    var meaning by mutableStateOf("")
    var example by mutableStateOf("")

    fun saveVocabulary(onSuccess: () -> Unit) {
        viewModelScope.launch {
            repository.addVocabulary(
                Vocabulary(word = word, meaning = meaning, example = example)
            )
            onSuccess()
        }
    }
}