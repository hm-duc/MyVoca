package com.hmd.myvoc.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hmd.myvoc.domain.model.Vocabulary

@Entity(tableName = "vocabularies")
data class VocabularyEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val word: String,
    val meaning: String,
    val example: String?
)

fun VocabularyEntity.toDomain() = Vocabulary(id, word, meaning, example)
fun Vocabulary.toEntity() = VocabularyEntity(id, word, meaning, example)