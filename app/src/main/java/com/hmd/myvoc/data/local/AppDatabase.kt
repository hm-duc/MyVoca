package com.hmd.myvoc.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [VocabularyEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract val vocabularyDao: VocabularyDao
}