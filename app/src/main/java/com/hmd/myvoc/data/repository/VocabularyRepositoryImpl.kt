package com.hmd.myvoc.data.repository

import com.hmd.myvoc.data.local.VocabularyDao
import com.hmd.myvoc.data.local.toDomain
import com.hmd.myvoc.data.local.toEntity
import com.hmd.myvoc.data.remote.VocabularyApi
import com.hmd.myvoc.domain.model.Vocabulary
import com.hmd.myvoc.domain.repository.VocabularyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class VocabularyRepositoryImpl @Inject constructor(
    private val dao: VocabularyDao,
    private val api: VocabularyApi
) : VocabularyRepository {

    override fun getVocabularies(): Flow<List<Vocabulary>> {
        return dao.getVocabularies().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun addVocabulary(vocabulary: Vocabulary) {
        dao.insertVocabulary(vocabulary.toEntity())
    }

    override suspend fun fetchFromRemote(): Result<Unit> {
        return try {
            val remoteVocabs = api.getVocabularies()
            remoteVocabs.forEach { dao.insertVocabulary(it) }
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}