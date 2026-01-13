package com.hmd.myvoc.presentation.my_vocabulary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hmd.myvoc.domain.repository.VocabularyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MyVocabularyViewModel @Inject constructor(
    repository: VocabularyRepository
) : ViewModel() {

    val vocabularies = repository.getVocabularies()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}