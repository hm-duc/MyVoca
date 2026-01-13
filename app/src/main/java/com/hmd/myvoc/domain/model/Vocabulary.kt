package com.hmd.myvoc.domain.model

data class Vocabulary(
    val id: Int = 0,
    val word: String,
    val meaning: String,
    val example: String? = null
)