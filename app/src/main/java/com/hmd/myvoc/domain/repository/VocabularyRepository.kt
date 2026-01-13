package com.hmd.myvoc.domain.repository

import com.hmd.myvoc.domain.model.Vocabulary
import kotlinx.coroutines.flow.Flow

interface VocabularyRepository {
    fun getVocabularies(): Flow<List<Vocabulary>>
    suspend fun addVocabulary(vocabulary: Vocabulary)
    suspend fun fetchFromRemote(): Result<Unit>
}