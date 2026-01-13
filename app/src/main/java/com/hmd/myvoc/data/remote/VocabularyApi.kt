package com.hmd.myvoc.data.remote

import com.hmd.myvoc.data.local.VocabularyEntity
import retrofit2.http.GET

interface VocabularyApi {
    @GET("vocabularies")
    suspend fun getVocabularies(): List<VocabularyEntity>
}