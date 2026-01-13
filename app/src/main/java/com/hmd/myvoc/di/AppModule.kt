package com.hmd.myvoc.di

import android.content.Context
import androidx.room.Room
import com.hmd.myvoc.data.local.AppDatabase
import com.hmd.myvoc.data.local.VocabularyDao
import com.hmd.myvoc.data.remote.VocabularyApi
import com.hmd.myvoc.data.repository.VocabularyRepositoryImpl
import com.hmd.myvoc.domain.repository.VocabularyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "myvoc_db"
        ).build()
    }

    @Provides
    fun provideVocabularyDao(db: AppDatabase): VocabularyDao = db.vocabularyDao

    @Provides
    @Singleton
    fun provideVocabularyApi(): VocabularyApi {
        return Retrofit.Builder()
            .baseUrl("https://api.example.com/") // Replace with actual base URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(VocabularyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideVocabularyRepository(
        dao: VocabularyDao,
        api: VocabularyApi
    ): VocabularyRepository {
        return VocabularyRepositoryImpl(dao, api)
    }
}